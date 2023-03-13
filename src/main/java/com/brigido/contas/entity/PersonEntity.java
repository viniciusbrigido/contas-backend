package com.brigido.contas.entity;

import com.brigido.contas.dto.person.UpdatePersonDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    private String name;
    private String cpf;
    private String address;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<AccountEntity> accounts;

    public void update(UpdatePersonDTO dto) {
        name = dto.getName();
        cpf = dto.getCpf();
        address = dto.getAddress();
    }
}
