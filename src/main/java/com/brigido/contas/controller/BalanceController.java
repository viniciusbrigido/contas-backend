package com.brigido.contas.controller;

import com.brigido.contas.dto.balance.ListBalanceDTO;
import com.brigido.contas.dto.balance.SearchBalanceDTO;
import com.brigido.contas.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @PostMapping("/find-balance")
    public BigDecimal findBalanceByCurrencyId(@RequestBody SearchBalanceDTO dto) {
        return balanceService.findBalanceByCurrencyId(dto);
    }

    @GetMapping("/find-balances-per-account/{accountId}")
    public List<ListBalanceDTO> findBalancesPerAccount(@PathVariable UUID accountId) {
        return balanceService.findBalancesPerAccount(accountId);
    }
}
