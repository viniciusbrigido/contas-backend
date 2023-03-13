package com.brigido.contas.controller;

import com.brigido.contas.dto.conta.*;
import com.brigido.contas.entity.ContaEntity;
import com.brigido.contas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/create")
    public ContaDTO create(@RequestBody ContaCreateDTO dto) {
        return contaService.create(dto);
    }

    @PutMapping("/update")
    public ContaDTO update(@RequestBody ContaUpdateDTO dto) {
        return contaService.update(dto);
    }

    @GetMapping("/{id}")
    public ContaMovimentacaoDTO getContaComMovimentacoes(@PathVariable UUID id) {
        return contaService.getContaComMovimentacoes(id);
    }

    @PostMapping
    public List<ContaListDTO> list(@RequestBody ContaSearchDTO dto) {
        return contaService.list(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        contaService.delete(id);
    }
}
