package com.brigido.contas.dto.person;

import com.brigido.contas.dto.address.AddressDTO;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreatePersonDTO {
    private String name;
    private String cpf;
    private String number;
    private String complement;
    private AddressDTO address;
}
