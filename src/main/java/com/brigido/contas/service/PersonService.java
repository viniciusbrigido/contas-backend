package com.brigido.contas.service;

import com.brigido.contas.dto.person.*;
import com.brigido.contas.entity.PersonEntity;
import java.util.List;
import java.util.UUID;

public interface PersonService {
    PersonDTO create(CreatePersonDTO dto);
    PersonDTO update(UpdatePersonDTO dto);
    List<PersonDTO> list();
    void delete(UUID id);
    PersonEntity findById(UUID id);
}
