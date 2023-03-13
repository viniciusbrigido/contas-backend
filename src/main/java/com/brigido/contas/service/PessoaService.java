package com.brigido.contas.service;

import com.brigido.contas.dto.pessoa.*;
import com.brigido.contas.entity.PessoaEntity;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    PessoaDTO create(PessoaCreateDTO pessoaCreateDTO);
    PessoaDTO update(PessoaUpdateDTO pessoaUpdateDTO);
    List<PessoaDTO> list();
    PessoaEntity findById(UUID id);
    void delete(UUID id);
}
