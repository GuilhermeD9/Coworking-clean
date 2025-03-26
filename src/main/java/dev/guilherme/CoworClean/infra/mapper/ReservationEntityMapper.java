package dev.guilherme.CoworClean.infra.mapper;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.infra.persistence.ReservationEntity;
import org.springframework.stereotype.Component;

@Component
public class ReservationEntityMapper {
    public ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.id(),
                reservation.sala(),
                reservation.locador(),
                reservation.inicio(),
                reservation.fim(),
                reservation.status()
        );
    }

    public Reservation toReservation(ReservationEntity reservationEntity) {
        return new Reservation(
                reservationEntity.getId(),
                reservationEntity.getSala(),
                reservationEntity.getLocador(),
                reservationEntity.getInicio(),
                reservationEntity.getFim(),
                reservationEntity.getStatus()
        );
    }
}
