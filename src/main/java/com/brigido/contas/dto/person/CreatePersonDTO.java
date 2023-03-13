package com.brigido.contas.dto.person;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreatePersonDTO {
    private String name;
    private String cpf;
    private String address;
}
