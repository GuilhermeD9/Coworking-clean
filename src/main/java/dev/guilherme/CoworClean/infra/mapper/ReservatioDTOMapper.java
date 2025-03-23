package dev.guilherme.CoworClean.infra.mapper;

import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.persistence.ReservationEntity;

public class ReservatioDTOMapper {
    public ReservationEntity toReservation(ReservationDTO dto) {
        return new ReservationEntity(null, dto.sala(), dto.locador(),
                dto.inicio(), dto.fim(), dto.status());

    }

    public ReservationDTO toDto(ReservationEntity entity) {
        return new ReservationDTO(entity.getSala(), entity.getLocador(), entity.getInicio(),
                entity.getFim(), entity.getStatus());
    }
}
