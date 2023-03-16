package com.brigido.contas.dto.account;

import com.brigido.contas.dto.balance.SimpleBalanceDTO;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SimpleAccountDTO {
    private UUID id;
    private String accountNumber;
    private List<SimpleBalanceDTO> balances;
}
