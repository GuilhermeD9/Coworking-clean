package dev.guilherme.CoworClean.core.getaway;

import dev.guilherme.CoworClean.core.entities.Reservation;

import java.util.List;

public interface ReservationGateway {
    Reservation criarReserva(Reservation reservation);
    List<Reservation> listarReservas();
}
