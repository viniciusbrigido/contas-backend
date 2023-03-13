package com.brigido.contas.repository;

import com.brigido.contas.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, UUID>, ContaRepositoryCustom {
}
