package com.brigido.contas.repository;

import com.brigido.contas.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, UUID> {
}
