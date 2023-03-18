package com.brigido.contas.config;

import com.brigido.contas.dto.account.AccountDTO;
import com.brigido.contas.dto.account.CreateAccountDTO;
import com.brigido.contas.dto.address.AddressDTO;
import com.brigido.contas.dto.movement.CreateMovementDTO;
import com.brigido.contas.dto.person.CreatePersonDTO;
import com.brigido.contas.dto.person.PersonDTO;
import com.brigido.contas.enumeration.MovementType;
import com.brigido.contas.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.*;

@Component
public class InitDatabase {

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private MovementService movementService;

    @PostConstruct
    public void fillDatabase() {
        fillPerson();
    }


    private void fillPerson() {
        PersonDTO person = personService.create(getPerson());
        AccountDTO account = accountService.create(getAccount1(person.getId()));
        accountService.create(getAccount2(person.getId()));

        fillMovement(account.getId());
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

    private CreateAccountDTO getAccount1(UUID personId) {
        return CreateAccountDTO.builder()
                .personId(personId)
                .accountNumber("123")
                .build();
    }

    private CreateAccountDTO getAccount2(UUID personId) {
        return CreateAccountDTO.builder()
                .personId(personId)
                .accountNumber("456")
                .build();
    }

    private void fillMovement(UUID accountId) {
        CreateMovementDTO movement = CreateMovementDTO.builder()
                .accountId(accountId)
                .value(BigDecimal.TEN)
                .type(MovementType.DEPOSIT)
                .build();

        movementService.create(movement);
    }
}
