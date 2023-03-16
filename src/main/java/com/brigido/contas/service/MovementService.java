package com.brigido.contas.service;

import com.brigido.contas.dto.balance.BalanceDTO;
import com.brigido.contas.dto.movement.*;

public interface MovementService {
    BalanceDTO create(CreateMovementDTO dto);
}
