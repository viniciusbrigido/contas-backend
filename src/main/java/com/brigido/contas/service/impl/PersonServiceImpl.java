package com.brigido.contas.service.impl;

import com.brigido.contas.dto.person.*;
import com.brigido.contas.entity.AddressEntity;
import com.brigido.contas.entity.PersonEntity;
import com.brigido.contas.exception.EntityNotFound;
import com.brigido.contas.repository.PersonRepository;
import com.brigido.contas.service.AddressService;
import com.brigido.contas.service.PersonService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import static java.util.Objects.*;
import static java.util.stream.Collectors.toList;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public PersonDTO create(CreatePersonDTO dto) {
        PersonEntity person = modelMapper.map(dto, PersonEntity.class);
        addressValidate(person, dto.getAddress().getCep());
        return modelMapper.map(personRepository.save(person), PersonDTO.class);
    }

    @Override
    public PersonDTO update(UpdatePersonDTO dto) {
        PersonEntity person = findById(dto.getId());
        person.setName(dto.getName());
        person.setCpf(dto.getCpf());
        addressValidate(person, dto.getAddress().getCep());
        return modelMapper.map(personRepository.save(person), PersonDTO.class);
    }

    private void addressValidate(PersonEntity person, String cep) {
        AddressEntity address = addressService.findByCep(cep);
        if (nonNull(address)) {
            person.setAddress(address);
        }
    }

    @Override
    public PersonEntity findById(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Pessoa não encontrada."));
    }

    @Override
    public List<PersonDTO> list() {
        return personRepository.findAll()
                .stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .collect(toList());
    }

    @Override
    public void delete(UUID id) {
        personRepository.deleteById(id);
    }
}
