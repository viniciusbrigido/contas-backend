package com.brigido.contas.dto.person;

import com.brigido.contas.dto.account.SimpleAccountDTO;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class PersonDTO {
    private UUID id;
    private String name;
    private String cpf;
    private String address;
    private List<SimpleAccountDTO> accounts;
}
