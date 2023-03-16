package com.brigido.contas.dto.movement;

import com.brigido.contas.enumeration.MovementType;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateMovementDTO {
    private UUID accountId;
    private UUID currencyId;
    private BigDecimal value;
    private MovementType type;

    public boolean isDeposit() {
        return type == MovementType.DEPOSIT;
    }
}
