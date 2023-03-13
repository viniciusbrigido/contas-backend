package com.brigido.contas.service;

import com.brigido.contas.dto.conta.ContaDTO;
import com.brigido.contas.dto.movimentacao.*;

public interface MovimentacaoService {
    ContaDTO create(MovimentacaoCreateDTO pessoaCreateDTO);
}
