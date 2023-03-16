package com.brigido.contas.entity;

import com.brigido.contas.enumeration.AccountStatus;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;
import static java.math.BigDecimal.*;
import static java.util.Objects.*;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity {

    public AccountEntity() {
        status = AccountStatus.OPEN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<BalanceEntity> balances;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public List<BalanceEntity> getBalances() {
        if (isNull(balances)) {
            balances = new ArrayList<>();
        }
        return balances;
    }

    public void update(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTotalBalances() {
        return balances.stream()
                .map(BalanceEntity::getValue)
                .reduce(ZERO, BigDecimal::add);
    }

    public boolean isAccountCloseable() {
        return getBalances().isEmpty() || getTotalBalances().compareTo(ZERO) == 0;
    }

    public void close() {
        status = AccountStatus.CLOSED;
    }
}
