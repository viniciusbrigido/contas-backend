package com.brigido.contas.entity;

import com.brigido.contas.enumeration.MovementType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
@Entity
@Table(name = "movement")
public class MovementEntity {

    public MovementEntity() {
        date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private LocalDateTime date;
}
