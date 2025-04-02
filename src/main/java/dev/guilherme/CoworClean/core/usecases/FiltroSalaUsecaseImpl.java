package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

import java.util.Optional;

public class FiltroSalaUsecaseImpl implements FiltroSalaUsecase {
    private final ReservationGateway reservationGateway;

    public FiltroSalaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Optional<Reservation> execute(String sala) {
        return reservationGateway.filtrarReservaPorSala(sala);
    }
}
