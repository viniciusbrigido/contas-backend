package com.brigido.contas.controller;

import com.brigido.contas.dto.person.*;
import com.brigido.contas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public PersonDTO create(@RequestBody CreatePersonDTO dto) {
        return personService.create(dto);
    }

    @PutMapping("/update")
    public PersonDTO update(@RequestBody UpdatePersonDTO dto) {
        return personService.update(dto);
    }

    @GetMapping
    public List<PersonDTO> list() {
        return personService.list();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        personService.delete(id);
    }
}
