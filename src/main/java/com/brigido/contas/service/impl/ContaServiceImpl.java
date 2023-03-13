package com.brigido.contas.service.impl;

import com.brigido.contas.dto.conta.*;
import com.brigido.contas.entity.ContaEntity;
import com.brigido.contas.exception.EntidadeNaoEncontradaException;
import com.brigido.contas.repository.ContaRepository;
import com.brigido.contas.service.ContaService;
import com.brigido.contas.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContaDTO create(ContaCreateDTO contaCreateDTO) {
        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setNumeroConta(contaCreateDTO.getNumeroConta());
        contaEntity.setPessoa(pessoaService.findById(contaCreateDTO.getPessoaId()));
        return modelMapper.map(contaRepository.save(contaEntity), ContaDTO.class);
    }

    @Override
    public ContaDTO update(ContaUpdateDTO contaUpdateDTO) {
        ContaEntity contaEntity = findById(contaUpdateDTO.getId());
        contaEntity.update(contaUpdateDTO.getNumeroConta());
        return modelMapper.map(contaRepository.save(contaEntity), ContaDTO.class);
    }

    @Override
    public ContaEntity findById(UUID id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Conta não encontrada."));
    }

    @Override
    public ContaMovimentacaoDTO getContaComMovimentacoes(UUID id) {
        ContaEntity contaEntity = findById(id);
        return modelMapper.map(contaRepository.save(contaEntity), ContaMovimentacaoDTO.class);
    }

    @Override
    public List<ContaListDTO> list(ContaSearchDTO dto) {
        return contaRepository.getContas(dto);
    }

    @Override
    public void delete(UUID id) {
        ContaEntity conta = findById(id);
        if (conta.getMovimentacoes().isEmpty()) {
            contaRepository.delete(conta);
            return;
        }
        conta.fechar();
        contaRepository.save(conta);
    }

    @Override
    public void updateValor(ContaEntity contaEntity) {
        contaRepository.save(contaEntity);
    }
}
