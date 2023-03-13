package com.brigido.contas.service.impl;

import com.brigido.contas.dto.conta.ContaDTO;
import com.brigido.contas.dto.movimentacao.*;
import com.brigido.contas.entity.ContaEntity;
import com.brigido.contas.entity.MovimentacaoEntity;
import com.brigido.contas.exception.SaldoInvalidoException;
import com.brigido.contas.repository.MovimentacaoRepository;
import com.brigido.contas.service.ContaService;
import com.brigido.contas.service.MovimentacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContaDTO create(MovimentacaoCreateDTO movimentacaoCreateDTO) {
        ContaEntity contaEntity = contaService.findById(movimentacaoCreateDTO.getContaId());
        movimentaConta(contaEntity, movimentacaoCreateDTO);
        contaService.updateValor(contaEntity);

        MovimentacaoEntity movimentacaoEntity = new MovimentacaoEntity();
        movimentacaoEntity.setConta(contaEntity);
        movimentacaoEntity.setTipo(movimentacaoCreateDTO.getTipo());
        movimentacaoEntity.setValor(movimentacaoCreateDTO.getValor());
        movimentacaoRepository.save(movimentacaoEntity);

        return modelMapper.map(contaEntity, ContaDTO.class);
    }

    private void movimentaConta(ContaEntity contaEntity, MovimentacaoCreateDTO movimentacaoCreateDTO) {
        if (movimentacaoCreateDTO.isDeposito()) {
            contaEntity.depositar(movimentacaoCreateDTO.getValor());
            return;
        }
        if (contaEntity.getValor().compareTo(movimentacaoCreateDTO.getValor()) < 0) {
            throw new SaldoInvalidoException("Saldo Inválido.");
        }
        contaEntity.retirar(movimentacaoCreateDTO.getValor());
    }
}
