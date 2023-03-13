package com.brigido.contas.dto.conta;

import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ContaDTO {
    private UUID id;
    private String numeroConta;
    private BigDecimal valor;
}
