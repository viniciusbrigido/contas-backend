package com.brigido.contas.dto.movement;

import com.brigido.contas.enumeration.MovementType;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SimpleMovementDTO {

    private UUID id;
    private BigDecimal value;
    private MovementType type;
    private LocalDateTime date;
}
