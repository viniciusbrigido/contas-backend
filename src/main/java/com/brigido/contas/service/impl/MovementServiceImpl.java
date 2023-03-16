package com.brigido.contas.service.impl;

import com.brigido.contas.dto.balance.BalanceDTO;
import com.brigido.contas.dto.movement.*;
import com.brigido.contas.entity.*;
import com.brigido.contas.entity.MovementEntity;
import com.brigido.contas.exception.InvalidBalanceException;
import com.brigido.contas.repository.MovementRepository;
import com.brigido.contas.service.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.Objects.*;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public BalanceDTO create(CreateMovementDTO dto) {
        CurrencyEntity currency = currencyService.findById(dto.getCurrencyId());
        AccountEntity account = accountService.findById(dto.getAccountId());

        BalanceEntity balance = balanceService.findOrReturnNew(currency, account);
        fillBalance(balance, currency, account, dto);
        fillMovement(balance, dto);

        return modelMapper.map(balance, BalanceDTO.class);
    }

    private void fillBalance(BalanceEntity balance, CurrencyEntity currency, AccountEntity account, CreateMovementDTO dto) {
        if (isNull(balance.getId())) {
            balance.setCurrency(currency);
            balance.setAccount(account);
        }
        balanceMovement(balance, dto);
        balanceService.updateValue(balance);
    }

    private void fillMovement(BalanceEntity balance, CreateMovementDTO dto) {
        MovementEntity movement = new MovementEntity();
        movement.setBalance(balance);
        movement.setType(dto.getType());
        movement.setValue(dto.getValue());
        movementRepository.save(movement);
        balance.getMovements().add(movement);
    }

    private void balanceMovement(BalanceEntity balance, CreateMovementDTO dto) {
        if (dto.isDeposit()) {
            balance.deposit(dto.getValue());
            return;
        }
        if (balance.getValue().compareTo(dto.getValue()) < 0) {
            throw new InvalidBalanceException("Saldo Inválido.");
        }
        balance.remove(dto.getValue());
    }
}
