package dev.guilherme.CoworClean.infra.getaway;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.infra.mapper.ReservationEntityMapper;
import dev.guilherme.CoworClean.infra.persistence.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationRepositoryGateway implements ReservationGateway {
    private final ReservationRepository repository;
    private final ReservationEntityMapper mapper;

    public ReservationRepositoryGateway(ReservationRepository repository, ReservationEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Reservation criarReserva(Reservation reservation) {
        repository.save(mapper.toEntity(reservation));
        return reservation;
    }
}
