package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

import java.util.List;

public class BuscarReservaCaseImpl implements BuscarReservaCase {
    private final ReservationGateway reservationGateway;

    public BuscarReservaCaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public List<Reservation> execute() {
        return reservationGateway.listarReservas();
    }
}
