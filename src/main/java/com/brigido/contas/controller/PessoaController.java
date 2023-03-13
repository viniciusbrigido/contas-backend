package com.brigido.contas.controller;

import com.brigido.contas.dto.pessoa.*;
import com.brigido.contas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/create")
    public PessoaDTO create(@RequestBody PessoaCreateDTO dto) {
        return pessoaService.create(dto);
    }

    @PutMapping("/update")
    public PessoaDTO update(@RequestBody PessoaUpdateDTO dto) {
        return pessoaService.update(dto);
    }

    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        pessoaService.delete(id);
    }
}
