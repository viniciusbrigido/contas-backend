package com.brigido.contas.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    private String cep;

    private String city;
    private String neighborhood;
    private String state;
    private String street;
}
