package com.brigido.contas.repository.impl;

import com.brigido.contas.dto.conta.ContaSearchDTO;
import com.brigido.contas.dto.conta.ContaListDTO;
import com.brigido.contas.entity.QContaEntity;
import com.brigido.contas.entity.QPessoaEntity;
import com.brigido.contas.enumeration.StatusConta;
import com.brigido.contas.repository.ContaRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import static java.util.Objects.*;

public class ContaRepositoryCustomImpl implements ContaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ContaListDTO> getContas(ContaSearchDTO dto) {
        final QContaEntity conta = QContaEntity.contaEntity;
        final QPessoaEntity pessoa = QPessoaEntity.pessoaEntity;

        JPAQuery<ContaListDTO> query = new JPAQueryFactory(em)
                .select(Projections.constructor(
                                ContaListDTO.class,
                                conta.id,
                                conta.numeroConta,
                                conta.valor,
                                pessoa.nome,
                                pessoa.cpf)
                )
                .from(conta)
                .leftJoin(conta.pessoa, pessoa)
                .where(conta.status.eq(StatusConta.ABERTA));

        if (nonNull(dto.getPersonId())) {
            query.where(pessoa.id.eq(dto.getPersonId()));
        }
        return query.fetch();
    }
}
