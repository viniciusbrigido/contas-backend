package com.brigido.contas.dto.balance;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ListBalanceDTO {
    private String name;
    private BigDecimal value;
}
