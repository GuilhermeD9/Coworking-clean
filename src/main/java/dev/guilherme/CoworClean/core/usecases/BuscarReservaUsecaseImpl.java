package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

import java.util.List;

public class BuscarReservaUsecaseImpl implements BuscarReservaUsecase {
    private final ReservationGateway reservationGateway;

    public BuscarReservaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public List<Reservation> execute() {
        return reservationGateway.listarReservas();
    }
}
