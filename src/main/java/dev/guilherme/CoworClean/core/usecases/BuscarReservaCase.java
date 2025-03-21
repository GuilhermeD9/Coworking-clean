package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;

public interface BuscarReservaCase {
    Reservation execute(Long id);
}
