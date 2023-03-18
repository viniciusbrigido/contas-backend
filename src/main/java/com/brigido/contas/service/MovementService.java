package com.brigido.contas.service;

import com.brigido.contas.dto.account.AccountDTO;
import com.brigido.contas.dto.movement.*;

public interface MovementService {
    AccountDTO create(CreateMovementDTO dto);
}
