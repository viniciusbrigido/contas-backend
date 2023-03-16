package com.brigido.contas.dto.balance;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreateBalanceDTO {
    private UUID currencyId;
    private UUID accountId;
}
