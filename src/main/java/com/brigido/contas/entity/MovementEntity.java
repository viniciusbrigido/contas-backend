package com.brigido.contas.entity;

import com.brigido.contas.enumeration.MovementType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Getter @Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movement")
public class MovementEntity {

    public MovementEntity() {
        date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private LocalDateTime date;
}
