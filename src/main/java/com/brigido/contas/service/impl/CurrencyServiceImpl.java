package com.brigido.contas.service.impl;

import com.brigido.contas.dto.currency.CurrencyDTO;
import com.brigido.contas.entity.CurrencyEntity;
import com.brigido.contas.exception.EntityNotFound;
import com.brigido.contas.repository.CurrencyRepository;
import com.brigido.contas.service.CurrencyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(List<CurrencyEntity> entities) {
        entities.forEach(entity -> {
            Optional<CurrencyEntity> optionalCurrency = currencyRepository.findByName(entity.getName());
            if (optionalCurrency.isPresent()) {
                CurrencyEntity persistedCurrency = optionalCurrency.get();
                persistedCurrency.update(entity.getPrice());
                currencyRepository.save(persistedCurrency);
            } else {
                currencyRepository.save(entity);
            }
        });
    }

    @Override
    public List<CurrencyDTO> list() {
        return currencyRepository.findAll()
                .stream().map(currency -> modelMapper.map(currency, CurrencyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyEntity findById(UUID id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Moeda não encontrada."));
    }

    @Override
    public CurrencyEntity findByName(String name) {
        return currencyRepository.findByName(name).orElse(null);
    }
}
