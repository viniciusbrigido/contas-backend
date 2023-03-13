package com.brigido.contas.service.impl;

import com.brigido.contas.dto.pessoa.*;
import com.brigido.contas.entity.PessoaEntity;
import com.brigido.contas.exception.EntidadeNaoEncontradaException;
import com.brigido.contas.repository.PessoaRepository;
import com.brigido.contas.service.PessoaService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import static java.util.stream.Collectors.toList;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) {
        PessoaEntity pessoaEntity = modelMapper.map(pessoaCreateDTO, PessoaEntity.class);
        return modelMapper.map(pessoaRepository.save(pessoaEntity), PessoaDTO.class);
    }

    @Override
    public PessoaDTO update(PessoaUpdateDTO pessoaUpdateDTO) {
        PessoaEntity pessoaEntity = findById(pessoaUpdateDTO.getId());
        pessoaEntity.update(pessoaUpdateDTO);
        return modelMapper.map(pessoaRepository.save(pessoaEntity), PessoaDTO.class);
    }

    @Override
    public PessoaEntity findById(UUID id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Pessoa não encontrada."));
    }

    @Override
    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaEntity -> modelMapper.map(pessoaEntity, PessoaDTO.class))
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        pessoaRepository.deleteById(id);
    }
}
