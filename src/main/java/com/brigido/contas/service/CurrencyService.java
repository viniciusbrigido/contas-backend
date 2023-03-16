package com.brigido.contas.service;

import com.brigido.contas.dto.currency.CurrencyDTO;
import com.brigido.contas.entity.CurrencyEntity;
import java.util.List;
import java.util.UUID;

public interface CurrencyService {
    void create(List<CurrencyEntity> entities);
    List<CurrencyDTO> list();
    CurrencyEntity findById(UUID id);
    CurrencyEntity findByName(String name);
}
