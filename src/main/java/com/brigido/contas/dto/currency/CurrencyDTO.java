package com.brigido.contas.dto.currency;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CurrencyDTO {
    private UUID id;
    private String name;
    private BigDecimal price;
    private LocalDateTime date;
}
