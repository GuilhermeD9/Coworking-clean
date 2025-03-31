package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.infra.exceptions.DuplicateRoomException;

public class CriarReservaUsecaseImpl implements CriarReservaUsecase {
    private final ReservationGateway reservationGateway;

    public CriarReservaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(Reservation reserva) {
        if (reservationGateway.salaOcupada(reserva.sala())) {
            throw new DuplicateRoomException("A sala número " + reserva.sala() + " já está reservada.");
        }
        return reservationGateway.criarReserva(reserva);
    }
}
