package com.brigido.contas.dto.movement;

import com.brigido.contas.enumeration.MovementType;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;
import static com.brigido.contas.enumeration.MovementType.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateMovementDTO {
    private UUID accountId;
    private UUID currencyId;
    private BigDecimal value;
    private MovementType type;
    private UUID accountTransferenceId;

    public MovementType getType(boolean isTransfer) {
        return isTransference()
        ? isTransfer ? TRANSFERENCE_DEPOSIT : TRANSFERENCE_REMOVE
        : type;
    }

    public boolean isDeposit() {
        return type == DEPOSIT;
    }

    public boolean isTransference() {
        return type == TRANSFERENCE;
    }
}
