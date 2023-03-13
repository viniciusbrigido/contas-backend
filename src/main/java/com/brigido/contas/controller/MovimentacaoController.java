package com.brigido.contas.controller;

import com.brigido.contas.dto.conta.ContaDTO;
import com.brigido.contas.dto.movimentacao.MovimentacaoCreateDTO;
import com.brigido.contas.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping("/create")
    public ContaDTO create(@RequestBody MovimentacaoCreateDTO dto) {
        return movimentacaoService.create(dto);
    }
}
