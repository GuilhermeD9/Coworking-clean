package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

public class CriarReservaUsecaseImpl implements CriarReservaUsecase {
    private final ReservationGateway reservationGateway;

    public CriarReservaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(Reservation reserva) {
        return reservationGateway.criarReserva(reserva);
    }
}
