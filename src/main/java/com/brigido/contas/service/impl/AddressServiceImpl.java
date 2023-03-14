package com.brigido.contas.service.impl;

import com.brigido.contas.entity.AddressEntity;
import com.brigido.contas.repository.AddressRepository;
import com.brigido.contas.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressEntity findByCep(String cep) {
        return addressRepository.findById(cep).orElse(null);
    }
}
