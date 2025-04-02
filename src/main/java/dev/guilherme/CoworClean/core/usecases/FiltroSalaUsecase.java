package dev.guilherme.CoworClean.core.usecases;

import dev.guilherme.CoworClean.core.entities.Reservation;

import java.util.Optional;

public interface FiltroSalaUsecase {
    Optional<Reservation> execute(String sala);
}
