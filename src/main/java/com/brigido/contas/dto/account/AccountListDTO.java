package com.brigido.contas.dto.account;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AccountListDTO {
    private UUID id;
    private String accountNumber;
    private String name;
    private String cpf;
}
