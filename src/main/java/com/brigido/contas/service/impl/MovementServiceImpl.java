package com.brigido.contas.service.impl;

import com.brigido.contas.dto.account.AccountDTO;
import com.brigido.contas.dto.movement.*;
import com.brigido.contas.entity.*;
import com.brigido.contas.entity.MovementEntity;
import com.brigido.contas.exception.InvalidBalanceException;
import com.brigido.contas.repository.MovementRepository;
import com.brigido.contas.service.AccountService;
import com.brigido.contas.service.MovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDTO create(CreateMovementDTO dto) {
        AccountEntity account = accountService.findById(dto.getAccountId());
        accountMovement(account, dto);
        accountService.updateValue(account);

        MovementEntity movement = new MovementEntity();
        movement.setAccount(account);
        movement.setType(dto.getType());
        movement.setValue(dto.getValue());
        movementRepository.save(movement);

        return modelMapper.map(account, AccountDTO.class);
    }

    private void accountMovement(AccountEntity account, CreateMovementDTO dto) {
        if (dto.isDeposit()) {
            account.deposit(dto.getValue());
            return;
        }
        if (account.getValue().compareTo(dto.getValue()) < 0) {
            throw new InvalidBalanceException("Saldo Inválido.");
        }
        account.remove(dto.getValue());
    }
}
