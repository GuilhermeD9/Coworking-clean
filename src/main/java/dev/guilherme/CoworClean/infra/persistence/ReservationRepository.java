package dev.guilherme.CoworClean.infra.persistence;

import dev.guilherme.CoworClean.core.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    Optional<Reservation> findBySala(String sala);
}
