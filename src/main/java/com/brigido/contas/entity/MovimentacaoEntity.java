package com.brigido.contas.entity;

import com.brigido.contas.enumeration.TipoMovimentacao;
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
@Table(name = "movimentacao")
public class MovimentacaoEntity {

    public MovimentacaoEntity() {
        data = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private ContaEntity conta;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private LocalDateTime data;
}
