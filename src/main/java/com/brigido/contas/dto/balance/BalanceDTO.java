package com.brigido.contas.dto.balance;

import com.brigido.contas.dto.account.AccountDTO;
import com.brigido.contas.dto.currency.CurrencyDTO;
import com.brigido.contas.dto.movement.SimpleMovementDTO;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BalanceDTO {

    private UUID id;
    private BigDecimal value;

    private CurrencyDTO currency;
    private AccountDTO account;
    private List<SimpleMovementDTO> movements;
}
