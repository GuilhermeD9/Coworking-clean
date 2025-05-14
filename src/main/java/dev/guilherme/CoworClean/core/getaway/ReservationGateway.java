package dev.guilherme.CoworClean.core.getaway;

import dev.guilherme.CoworClean.core.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationGateway {
    Reservation criarReserva(Reservation reservation);
    List<Reservation> listarReservas();
    boolean salaOcupada(String sala);
    Optional<Reservation> filtrarReservaPorSala(String sala);
    void deletarReserva(Long id);
    String gerarIdentificador();
}
