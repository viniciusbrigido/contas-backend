package com.brigido.contas.dto.address;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class AddressDTO {
    private String cep;
    private String city;
    private String neighborhood;
    private String state;
    private String street;
}
