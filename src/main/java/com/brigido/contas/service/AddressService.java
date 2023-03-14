package com.brigido.contas.service;

import com.brigido.contas.entity.AddressEntity;

public interface AddressService {
    AddressEntity findByCep(String cep);
}
