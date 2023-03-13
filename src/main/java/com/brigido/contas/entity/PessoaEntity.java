package com.brigido.contas.entity;

import com.brigido.contas.dto.pessoa.PessoaUpdateDTO;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(of = "id")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
@Table(name = "pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", unique = true, nullable = false, updatable = false)
    private UUID id;

    private String nome;

    private String cpf;
    private String endereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<ContaEntity> contas;

    public void update(PessoaUpdateDTO pessoaUpdateDTO) {
        nome = pessoaUpdateDTO.getNome();
        cpf = pessoaUpdateDTO.getCpf();
        endereco = pessoaUpdateDTO.getEndereco();
    }
}
