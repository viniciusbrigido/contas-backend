package com.brigido.contas.dto.account;

import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class AccountListDTO {
    private UUID id;
    private String accountNumber;
    private BigDecimal value;
    private String name;
    private String cpf;
}
