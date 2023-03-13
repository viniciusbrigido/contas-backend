package com.brigido.contas.controller;

import com.brigido.contas.dto.account.*;
import com.brigido.contas.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public AccountDTO create(@RequestBody CreateAccountDTO dto) {
        return accountService.create(dto);
    }

    @PutMapping("/update")
    public AccountDTO update(@RequestBody UpdateAccountDTO dto) {
        return accountService.update(dto);
    }

    @GetMapping("/{id}")
    public AccountMovementDTO getAccountWithMovements(@PathVariable UUID id) {
        return accountService.getAccountWithMovements(id);
    }

    @PostMapping
    public List<AccountListDTO> getAccounts(@RequestBody SearchAccountDTO dto) {
        return accountService.getAccounts(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        accountService.delete(id);
    }
}
