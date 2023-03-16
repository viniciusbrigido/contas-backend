package com.brigido.contas.service.impl;

import com.brigido.contas.dto.balance.*;
import com.brigido.contas.entity.*;
import com.brigido.contas.repository.BalanceRepository;
import com.brigido.contas.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BalanceDTO create(CreateBalanceDTO dto) {
        CurrencyEntity currency = currencyService.findById(dto.getCurrencyId());
        AccountEntity account = accountService.findById(dto.getAccountId());

        BalanceEntity balanceEntity = new BalanceEntity();
        balanceEntity.setAccount(account);
        balanceEntity.setCurrency(currency);
        balanceRepository.save(balanceEntity);
        return modelMapper.map(balanceEntity, BalanceDTO.class);
    }

    @Override
    public void updateValue(BalanceEntity balance) {
        balanceRepository.save(balance);
    }

    @Override
    public BalanceEntity findOrReturnNew(CurrencyEntity currency, AccountEntity account) {
        return balanceRepository.findByCurrencyAndAccount(currency, account).orElse(new BalanceEntity());
    }

    @Override
    public List<ListBalanceDTO> findBalancesPerAccount(UUID accountId) {
        List<ListBalanceDTO> balancesDTO = new ArrayList<>();
        AccountEntity account = accountService.findById(accountId);

        balanceRepository.findByAccount(account).forEach(balance -> {
            balancesDTO.add(ListBalanceDTO.builder()
                            .name(balance.getCurrency().getName())
                            .value(balance.getValue())
                            .build()
            );
        });
        return balancesDTO;
    }

    @Override
    public BigDecimal findBalanceByCurrencyId(SearchBalanceDTO dto) {
        CurrencyEntity currency = currencyService.findById(dto.getCurrencyId());
        AccountEntity account = accountService.findById(dto.getAccountId());
        return findOrReturnNew(currency, account).getValue();
    }
}
