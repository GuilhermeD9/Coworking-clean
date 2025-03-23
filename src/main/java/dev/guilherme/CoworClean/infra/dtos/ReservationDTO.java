package dev.guilherme.CoworClean.infra.dtos;

import dev.guilherme.CoworClean.core.enums.Status;

import java.time.LocalDateTime;

public record ReservationDTO(String sala, String locador, LocalDateTime inicio,
                             LocalDateTime fim, Status status) {
}
