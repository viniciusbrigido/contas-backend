package com.brigido.contas.controller;

import com.brigido.contas.dto.currency.CurrencyDTO;
import com.brigido.contas.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDTO> list() {
        return currencyService.list();
    }
}
