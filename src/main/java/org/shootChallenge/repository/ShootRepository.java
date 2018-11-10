package org.shootChallenge.repository;

import org.shootChallenge.entity.Shoot;
import org.shooterCRUD.entity.Shooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShootRepository extends JpaRepository<Shoot, Long> {
}

