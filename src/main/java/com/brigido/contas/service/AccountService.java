package com.brigido.contas.service;

import com.brigido.contas.dto.account.*;
import com.brigido.contas.entity.AccountEntity;
import java.util.List;
import java.util.UUID;

public interface AccountService {
    AccountDTO create(CreateAccountDTO dto);
    AccountDTO update(UpdateAccountDTO dto);
    AccountMovementDTO getAccountWithMovements(UUID id);
    List<AccountListDTO> getAccounts(SearchAccountDTO dto);
    AccountEntity findById(UUID id);
    void delete(UUID id);
    void close(UUID id);
}
