package com.brigido.contas.dto.conta;

import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ContaListDTO {
    private UUID id;
    private String numeroConta;
    private BigDecimal valor;
    private String nome;
    private String cpf;
}
