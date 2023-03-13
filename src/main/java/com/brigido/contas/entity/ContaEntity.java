package com.brigido.contas.entity;

import com.brigido.contas.enumeration.StatusConta;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Getter @Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "conta")
public class ContaEntity {

    public ContaEntity() {
        valor = BigDecimal.ZERO;
        status = StatusConta.ABERTA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoaEntity pessoa;

    @Column(name = "numero_conta")
    private String numeroConta;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<MovimentacaoEntity> movimentacoes;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusConta status;

    public void depositar(BigDecimal valorDeposito) {
        valor = valor.add(valorDeposito);
    }

    public void retirar(BigDecimal valorRetirada) {
        valor = valor.subtract(valorRetirada);
    }

    public void update(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void fechar() {
        status = StatusConta.FECHADA;
    }
}
