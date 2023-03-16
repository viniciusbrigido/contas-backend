package com.brigido.contas.config;

import com.brigido.contas.dto.account.AccountDTO;
import com.brigido.contas.dto.account.CreateAccountDTO;
import com.brigido.contas.dto.address.AddressDTO;
import com.brigido.contas.dto.currency.CurrencyResponseDTO;
import com.brigido.contas.dto.movement.CreateMovementDTO;
import com.brigido.contas.dto.person.CreatePersonDTO;
import com.brigido.contas.dto.person.PersonDTO;
import com.brigido.contas.entity.CurrencyEntity;
import com.brigido.contas.enumeration.MovementType;
import com.brigido.contas.rest.CurrencyRest;
import com.brigido.contas.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class InitDatabase {

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private MovementService movementService;

    @Autowired
    private CurrencyRest currencyRest;

    @PostConstruct
    public void fillDatabase() {
        fillCurrency();
        fillPerson();
    }

    private void fillCurrency() {
        List<CurrencyResponseDTO.Currency> currenciesRest = currencyRest.getCurrenciesBase();
        List<CurrencyEntity> entities = new ArrayList<>();
        entities.add(getReal());
        entities.addAll(getCurrenciesRest());

        currencyService.create(entities);
    }

    private CurrencyEntity getReal() {
        CurrencyEntity currency = new CurrencyEntity();
        currency.setName("Real Brasileiro");
        currency.setPrice(BigDecimal.ONE);
        return currency;
    }

    private List<CurrencyEntity> getCurrenciesRest() {
        List<CurrencyResponseDTO.Currency> currenciesRest = currencyRest.getCurrenciesBase();
        return currenciesRest.stream()
                .map(this::currencyDtoToEntity)
                .collect(Collectors.toList());
    }

    private CurrencyEntity currencyDtoToEntity(CurrencyResponseDTO.Currency currency) {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setName(currency.getName());
        currencyEntity.setPrice(currency.getPrice());
        return currencyEntity;
    }

    private void fillPerson() {
        PersonDTO person = personService.create(getPerson());
        AccountDTO account = accountService.create(getAccount(person.getId()));

        CurrencyEntity currency = currencyService.findByName("Real Brasileiro");
        fillMovement(account.getId(), currency.getId());
    }

    private CreatePersonDTO getPerson() {
        return CreatePersonDTO.builder()
                .name("Vinicius Brigido")
                .cpf("12345678912")
                .number("343")
                .complement("Proximo a Celesc")
                .address(getAddress())
                .build();
    }

    private AddressDTO getAddress() {
        return AddressDTO.builder()
                .cep("88701610")
                .city("Tubarão")
                .neighborhood("Centro")
                .state("SC")
                .street("Rua Santos Dumont")
                .build();
    }

    private CreateAccountDTO getAccount(UUID personId) {
        return CreateAccountDTO.builder()
                .personId(personId)
                .accountNumber("123")
                .build();
    }

    private void fillMovement(UUID accountId, UUID currencyId) {
        CreateMovementDTO movement = CreateMovementDTO.builder()
                .accountId(accountId)
                .currencyId(currencyId)
                .value(BigDecimal.TEN)
                .type(MovementType.DEPOSIT)
                .build();

        movementService.create(movement);
    }
}
