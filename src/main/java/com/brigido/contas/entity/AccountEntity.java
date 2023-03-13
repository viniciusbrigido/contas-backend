package com.brigido.contas.entity;

import com.brigido.contas.enumeration.AccountStatus;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;
import static java.util.Objects.*;

@EqualsAndHashCode(of = "id")
@Getter @Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class AccountEntity {

    public AccountEntity() {
        value = BigDecimal.ZERO;
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
    private List<MovementEntity> movements;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public List<MovementEntity> getMovements() {
        if (isNull(movements)) {
            movements = new ArrayList<>();
        }
        return movements;
    }

    public void deposit(BigDecimal value) {
        this.value = value.add(value);
    }

    public void remove(BigDecimal value) {
        this.value = value.subtract(value);
    }

    public void update(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void close() {
        status = AccountStatus.CLOSED;
    }

    public boolean hasMovements() {
        return !getMovements().isEmpty();
    }
}
