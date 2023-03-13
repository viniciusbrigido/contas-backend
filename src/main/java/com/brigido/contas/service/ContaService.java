package com.brigido.contas.service;

import com.brigido.contas.dto.conta.*;
import com.brigido.contas.entity.ContaEntity;
import java.util.List;
import java.util.UUID;

public interface ContaService {
    ContaDTO create(ContaCreateDTO contaCreateDTO);
    ContaDTO update(ContaUpdateDTO contaUpdateDTO);
    ContaEntity findById(UUID id);
    ContaMovimentacaoDTO getContaComMovimentacoes(UUID id);
    List<ContaListDTO> list(ContaSearchDTO dto);
    void delete(UUID id);
    void updateValor(ContaEntity contaEntity);
}
