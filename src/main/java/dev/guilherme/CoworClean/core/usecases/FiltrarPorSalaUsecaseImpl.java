package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

import java.util.Optional;

public class FiltrarPorSalaUsecaseImpl implements FiltrarPorSalaUsecase {
    private final ReservationGateway reservationGateway;

    public FiltrarPorSalaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Optional<Reservation> execute(String sala) {
        return reservationGateway.filtrarReservaPorSala(sala);
    }
}
