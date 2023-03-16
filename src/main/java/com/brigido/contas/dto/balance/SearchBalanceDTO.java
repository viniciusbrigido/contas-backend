package com.brigido.contas.dto.balance;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SearchBalanceDTO {
    private UUID currencyId;
    private UUID accountId;
}
