package com.brigido.contas.dto.pessoa;

import com.brigido.contas.dto.conta.ContaSimpleDTO;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class PessoaDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private String endereco;
    private List<ContaSimpleDTO> contas;
}
