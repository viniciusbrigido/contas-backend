package com.brigido.contas.dto.account;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateAccountDTO {
    private UUID personId;
    private String accountNumber;
}
