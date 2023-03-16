package com.brigido.contas.dto.balance;

import com.brigido.contas.dto.movement.SimpleMovementDTO;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ListBalanceDTO {
    private String name;
    private BigDecimal value;
    private List<SimpleMovementDTO> movements;
}
