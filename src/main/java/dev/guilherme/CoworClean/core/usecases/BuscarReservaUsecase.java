package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;

import java.util.List;

public interface BuscarReservaUsecase {
    List<Reservation> execute();
}
