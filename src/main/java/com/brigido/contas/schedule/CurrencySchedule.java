package com.brigido.contas.schedule;

import com.brigido.contas.dto.currency.CurrencyResponseDTO;
import com.brigido.contas.entity.CurrencyEntity;
import com.brigido.contas.rest.CurrencyRest;
import com.brigido.contas.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencySchedule {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyRest currencyRest;

    public void currencySchedule() {
        List<CurrencyResponseDTO.Currency> currenciesRest = currencyRest.getCurrenciesBase();
        List<CurrencyEntity> entities = currenciesRest.stream()
                .map(this::currencyDtoToEntity)
                .collect(Collectors.toList());

        entities.add(getReal());
        currencyService.create(entities);
    }

    private CurrencyEntity getReal() {
        CurrencyEntity currency = new CurrencyEntity();
        currency.setName("Real Brasileiro");
        currency.setPrice(BigDecimal.ONE);
        return currency;
    }

    private CurrencyEntity currencyDtoToEntity(CurrencyResponseDTO.Currency currency) {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setName(currency.getName());
        currencyEntity.setPrice(currency.getPrice());
        return currencyEntity;
    }
}
