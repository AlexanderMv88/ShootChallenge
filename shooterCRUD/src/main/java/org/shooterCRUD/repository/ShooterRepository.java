package org.shooterCRUD.repository;

import org.shooterCRUD.entity.Shooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShooterRepository extends JpaRepository<Shooter, Long> {
}
