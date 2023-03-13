package com.brigido.contas.repository;

import com.brigido.contas.entity.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, UUID> {
}
