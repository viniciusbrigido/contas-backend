package com.brigido.contas.dto.person;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePersonDTO {
    private UUID id;
    private String name;
    private String cpf;
    private String address;
}
