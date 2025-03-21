package dev.guilherme.CoworClean.core.entities;

import dev.guilherme.CoworClean.core.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Reservation(Long id, String sala, String locador, LocalDate data,
                          LocalDateTime horaInicio, LocalDateTime horaFim, Status status) {
}
