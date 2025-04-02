package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.infra.exceptions.NotFoundRoomException;

import java.util.Optional;

public class FiltrarPorSalaUsecaseImpl implements FiltrarPorSalaUsecase {
    private final ReservationGateway reservationGateway;

    public FiltrarPorSalaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(String sala) {
        return reservationGateway.filtrarReservaPorSala(sala)
                .orElseThrow(() -> new NotFoundRoomException("Reserva na sala " + sala + " não encontrado"));
    }
}
