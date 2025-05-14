package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

public class DeletarReservaUsecaseImpl implements DeletarReservaUsecase {
    private final ReservationGateway reservationGateway;

    public DeletarReservaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public void execute(Long id) {
        reservationGateway.deletarReserva(id);
    }
}
