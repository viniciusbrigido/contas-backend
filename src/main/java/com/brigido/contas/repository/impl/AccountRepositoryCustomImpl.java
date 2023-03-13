package com.brigido.contas.repository.impl;

import com.brigido.contas.dto.account.AccountSearchDTO;
import com.brigido.contas.dto.account.AccountListDTO;
import com.brigido.contas.repository.AccountRepositoryCustom;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AccountListDTO> getAccounts(AccountSearchDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ")
           .append(" new com.brigido.contas.dto.account.AccountListDTO( ")
           .append("    a.id AS id, ")
           .append("    a.accountNumber AS accountNumber, ")
           .append("    a.value AS value, ")
           .append("    p.name AS name, ")
           .append("    p.cpf AS cpf ")
           .append(" ) ")
           .append(" FROM AccountEntity a ")
           .append(" LEFT JOIN PersonEntity p ON (a.person.id = p.id) ")
           .append(" WHERE a.status = 'OPEN' ");

        if (Objects.nonNull(dto.getPersonId())) {
            sql.append(" AND p.id = :personId ");
        }

        TypedQuery<AccountListDTO> query = em.createQuery(sql.toString(), AccountListDTO.class);
        if (Objects.nonNull(dto.getPersonId())) {
            query.setParameter("personId", dto.getPersonId());
        }
        return query.getResultList();
    }
}
