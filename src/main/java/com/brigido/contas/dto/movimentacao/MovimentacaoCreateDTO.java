package com.brigido.contas.dto.movimentacao;

import com.brigido.contas.enumeration.TipoMovimentacao;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MovimentacaoCreateDTO {
    private UUID contaId;
    private BigDecimal valor;
    private TipoMovimentacao tipo;

    public boolean isDeposito() {
        return tipo == TipoMovimentacao.DEPOSITO;
    }
}
