package com.brigido.contas.repository;

import com.brigido.contas.dto.conta.ContaSearchDTO;
import com.brigido.contas.dto.conta.ContaListDTO;
import java.util.List;

public interface ContaRepositoryCustom {
    List<ContaListDTO> getContas(ContaSearchDTO dto);
}
