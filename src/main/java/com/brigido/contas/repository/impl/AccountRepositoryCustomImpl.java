package com.brigido.contas.repository.impl;

import com.brigido.contas.dto.account.SearchAccountDTO;
import com.brigido.contas.dto.account.AccountListDTO;
import com.brigido.contas.entity.AccountEntity;
import com.brigido.contas.entity.PersonEntity;
import com.brigido.contas.enumeration.AccountStatus;
import com.brigido.contas.repository.AccountRepositoryCustom;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.List;
import java.util.Objects;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AccountListDTO> getAccounts(SearchAccountDTO dto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AccountListDTO> cq = cb.createQuery(AccountListDTO.class);
        Root<AccountEntity> root = cq.from(AccountEntity.class);
        Join<AccountEntity, PersonEntity> joinPerson = root.join("person", JoinType.LEFT);

        cq.select(cb.construct(AccountListDTO.class,
                root.get("id"),
                root.get("accountNumber"),
                root.get("value"),
                joinPerson.get("name"),
                joinPerson.get("cpf")));

        cq.where(cb.equal(root.get("status"), AccountStatus.OPEN));
        if (Objects.nonNull(dto.getPersonId())) {
            cq.where(cb.equal(joinPerson.get("id"), dto.getPersonId()));
        }

        TypedQuery<AccountListDTO> query = em.createQuery(cq);
        return query.getResultList();
    }
}
