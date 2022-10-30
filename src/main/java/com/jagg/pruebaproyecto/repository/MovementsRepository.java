package com.jagg.pruebaproyecto.repository;

import com.jagg.pruebaproyecto.entities.Movements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Long> {
}
