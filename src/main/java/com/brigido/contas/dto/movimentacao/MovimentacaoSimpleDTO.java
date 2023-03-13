package com.brigido.contas.dto.movimentacao;

import com.brigido.contas.enumeration.TipoMovimentacao;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MovimentacaoSimpleDTO {

    private UUID id;
    private BigDecimal valor;
    private TipoMovimentacao tipo;
    private LocalDateTime data;
}
