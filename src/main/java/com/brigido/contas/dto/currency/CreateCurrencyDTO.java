package com.brigido.contas.dto.currency;

import lombok.*;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreateCurrencyDTO {
    private String name;
    private BigDecimal price;
}
