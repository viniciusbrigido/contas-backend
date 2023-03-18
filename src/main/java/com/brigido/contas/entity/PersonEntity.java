package com.brigido.contas.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
import static java.util.Objects.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String cpf;

    private String number;
    private String complement;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    public List<AccountEntity> getAccounts() {
        if (isNull(accounts)) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public boolean hasMovements() {
        return getAccounts().stream().anyMatch(AccountEntity::hasMovements);
    }
}
