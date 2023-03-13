package com.brigido.contas.dto.conta;

import com.brigido.contas.dto.movimentacao.MovimentacaoSimpleDTO;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaMovimentacaoDTO {
    private UUID id;
    private String numeroConta;
    private BigDecimal valor;
    private List<MovimentacaoSimpleDTO> movimentacoes;
}
