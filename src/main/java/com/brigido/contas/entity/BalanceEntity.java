package com.brigido.contas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;
import static java.util.Objects.isNull;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name = "balance")
public class BalanceEntity {

    public BalanceEntity() {
        value = BigDecimal.ZERO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    private BigDecimal value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id")
    private CurrencyEntity currency;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL)
    private List<MovementEntity> movements;

    public List<MovementEntity> getMovements() {
        if (isNull(movements)) {
            movements = new ArrayList<>();
        }
        return movements;
    }

    public void deposit(BigDecimal value) {
        this.value = this.value.add(value);
    }

    public void remove(BigDecimal value) {
        this.value = this.value.subtract(value);
    }
}
