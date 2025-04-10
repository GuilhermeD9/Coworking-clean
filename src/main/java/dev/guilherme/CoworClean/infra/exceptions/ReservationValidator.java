package dev.guilherme.CoworClean.infra.exceptions;

import dev.guilherme.CoworClean.core.entities.Reservation;

public class ReservationValidator {
    public static void validarCamposObrigatorios(Reservation reservation) {
        if (reservation.sala() == null || reservation.sala().isBlank()) {
            throw new NotNullException("O campo SALA é obrigatório");
        }
        if (reservation.locador() == null || reservation.locador().isBlank()) {
            throw new NotNullException("O campo LOCADOR é obrigatório");
        }
        if (reservation.inicio() == null) {
            throw new NotNullException("A data de INICIO é obrigatória");
        }
    }
}
