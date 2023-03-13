package com.brigido.contas.dto.pessoa;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaUpdateDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private String endereco;
}
