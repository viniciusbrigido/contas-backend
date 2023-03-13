package com.brigido.contas.dto.conta;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ContaCreateDTO {
    private UUID pessoaId;
    private String numeroConta;
}
