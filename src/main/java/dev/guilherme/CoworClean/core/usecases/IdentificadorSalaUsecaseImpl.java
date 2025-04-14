package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;

public class IdentificadorSalaUsecaseImpl implements IdentificadorSalaUsecase {
    private final ReservationGateway reservationGateway;

    public IdentificadorSalaUsecaseImpl(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public String execute() {
        return reservationGateway.gerarIdentificador();
    }
}
