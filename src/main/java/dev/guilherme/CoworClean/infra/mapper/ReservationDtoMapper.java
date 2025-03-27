package dev.guilherme.CoworClean.infra.mapper;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.persistence.ReservationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationDtoMapper {
    public Reservation toReservation(ReservationDTO dto) {
        return new Reservation(dto.id(), dto.sala(), dto.locador(),
                dto.inicio(), dto.fim(), dto.status());

    }

    public ReservationDTO toDto(Reservation entity) {
        return new ReservationDTO(entity.id(), entity.sala(), entity.locador(), entity.inicio(),
                entity.fim(), entity.status());
    }

    public List<ReservationDTO> listResrvationToDto(List<Reservation> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
