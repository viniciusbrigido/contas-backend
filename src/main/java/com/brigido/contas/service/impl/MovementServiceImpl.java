package com.brigido.contas.service.impl;

import com.brigido.contas.dto.account.AccountDTO;
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

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public AccountDTO create(CreateMovementDTO dto) {
        AccountEntity account = accountService.findById(dto.getAccountId());
        fillMovement(dto, account,false);
        accountMovement(account, dto, false);
        return modelMapper.map(account, AccountDTO.class);
    }

    private void fillMovement(CreateMovementDTO dto, AccountEntity account, boolean isTransfer) {
        MovementEntity movement = new MovementEntity();
        movement.setAccount(account);
        movement.setType(dto.getType(isTransfer));
        movement.setValue(dto.getValue());
        movementRepository.save(movement);
    }

    private void accountMovement(AccountEntity account, CreateMovementDTO dto, boolean isTransfer) {
        if (dto.isDeposit() || isTransfer) {
            account.deposit(dto.getValue());
            return;
        }
        if (account.getValue().compareTo(dto.getValue()) < 0) {
            throw new InvalidBalanceException("Saldo Inválido.");
        }
        account.remove(dto.getValue());
        if (dto.isTransference()) {
            transfer(dto);
        }
    }

    private void transfer(CreateMovementDTO dto) {
        AccountEntity accountTransference = accountService.findById(dto.getAccountTransferenceId());
        fillMovement(dto, accountTransference, true);
        accountMovement(accountTransference, dto, true);
    }
}
