package com.brigido.contas.service;

import com.brigido.contas.dto.balance.*;
import com.brigido.contas.entity.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface BalanceService {
    BalanceDTO create(CreateBalanceDTO dto);
    void updateValue(BalanceEntity balance);
    BalanceEntity findOrReturnNew(CurrencyEntity currency, AccountEntity account);
    BigDecimal findBalanceByCurrencyId(SearchBalanceDTO dto);
    List<ListBalanceDTO> findBalancesPerAccount(UUID accountId);
}
