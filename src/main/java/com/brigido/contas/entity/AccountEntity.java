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
        value = ZERO;
    }

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<MovementEntity> movements;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private BigDecimal value;

    public List<MovementEntity> getBalances() {
        if (isNull(movements)) {
            movements = new ArrayList<>();
        }
        return movements;
    }

    public void update(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTotalBalances() {
        return movements.stream()
                .map(MovementEntity::getValue)
                .reduce(ZERO, BigDecimal::add);
    }

    public boolean isAccountCloseable() {
        return getBalances().isEmpty() || getTotalBalances().compareTo(ZERO) == 0;
    }

    public void close() {
        status = AccountStatus.CLOSED;
    }

    public boolean hasMovements() {
        return !getBalances().isEmpty();
    }

    public void deposit(BigDecimal value) {
        this.value = this.value.add(value);
    }

    public void remove(BigDecimal value) {
        this.value = this.value.subtract(value);
    }
}
