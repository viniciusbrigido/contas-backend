package com.brigido.contas.repository;

import com.brigido.contas.dto.account.SearchAccountDTO;
import com.brigido.contas.dto.account.AccountListDTO;
import java.util.List;

public interface AccountRepositoryCustom {
    List<AccountListDTO> getAccounts(SearchAccountDTO dto);
}
