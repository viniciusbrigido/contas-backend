package com.brigido.contas.dto.person;

import com.brigido.contas.dto.account.SimpleAccountDTO;
import com.brigido.contas.dto.address.AddressDTO;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PersonDTO {
    private UUID id;
    private String name;
    private String cpf;
    private String number;
    private String complement;
    private AddressDTO address;
    private List<SimpleAccountDTO> accounts;
}
