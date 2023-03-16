package com.brigido.contas.repository;

import com.brigido.contas.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceEntity, UUID> {

    Optional<BalanceEntity> findByCurrencyAndAccount(CurrencyEntity currency, AccountEntity account);
    List<BalanceEntity> findByAccount(AccountEntity account);
}
