package com.brigido.contas.service.impl;

import com.brigido.contas.dto.account.*;
import com.brigido.contas.entity.AccountEntity;
import com.brigido.contas.exception.EntityNotFound;
import com.brigido.contas.repository.AccountRepository;
import com.brigido.contas.service.AccountService;
import com.brigido.contas.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDTO create(CreateAccountDTO dto) {
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(dto.getAccountNumber());
        account.setPerson(personService.findById(dto.getPersonId()));
        return modelMapper.map(accountRepository.save(account), AccountDTO.class);
    }

    @Override
    public AccountDTO update(UpdateAccountDTO dto) {
        AccountEntity account = findById(dto.getId());
        account.update(dto.getAccountNumber());
        return modelMapper.map(accountRepository.save(account), AccountDTO.class);
    }

    @Override
    public AccountEntity findById(UUID id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Conta não encontrada."));
    }

    @Override
    public AccountMovementDTO getAccountWithMovements(UUID id) {
        AccountEntity account = findById(id);
        return modelMapper.map(accountRepository.save(account), AccountMovementDTO.class);
    }

    @Override
    public List<AccountListDTO> getAccounts(SearchAccountDTO dto) {
        return accountRepository.getAccounts(dto);
    }

    @Override
    public void delete(UUID id) {
        AccountEntity account = findById(id);
        if (account.hasMovements()) {
            account.close();
            accountRepository.save(account);
            return;
        }
        accountRepository.delete(account);
    }

    @Override
    public void updateValue(AccountEntity account) {
        accountRepository.save(account);
    }
}
