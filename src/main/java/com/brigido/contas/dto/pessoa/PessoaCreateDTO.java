package com.brigido.contas.dto.pessoa;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class PessoaCreateDTO {
    private String nome;
    private String cpf;
    private String endereco;
}
