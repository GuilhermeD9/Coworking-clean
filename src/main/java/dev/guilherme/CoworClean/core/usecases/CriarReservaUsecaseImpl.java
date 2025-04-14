package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.infra.exceptions.DuplicateRoomException;
import dev.guilherme.CoworClean.infra.exceptions.ReservationValidator;

public class CriarReservaUsecaseImpl implements CriarReservaUsecase {
    private final ReservationGateway reservationGateway;
    private final IdentificadorSalaUsecase identificadorSalaUsecase;

    public CriarReservaUsecaseImpl(ReservationGateway reservationGateway, IdentificadorSalaUsecase identificadorSalaUsecase) {
        this.reservationGateway = reservationGateway;
        this.identificadorSalaUsecase = identificadorSalaUsecase;
    }

    @Override
    public Reservation execute(Reservation reserva) {
        Reservation reservaNova = new Reservation(
                reserva.id(), identificadorSalaUsecase.execute(), reserva.locador(),
                reserva.inicio(), reserva.fim(), reserva.status()
        );

        if (reservationGateway.salaOcupada(reserva.sala())) {
            throw new DuplicateRoomException("A sala número " + reservaNova.sala() + " já está reservada.");
        }
        ReservationValidator.validarCamposObrigatorios(reservaNova);
        return reservationGateway.criarReserva(reservaNova);
    }
}
