package dev.guilherme.CoworClean.infra.getaway;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.infra.mapper.ReservationEntityMapper;
import dev.guilherme.CoworClean.infra.persistence.ReservationEntity;
import dev.guilherme.CoworClean.infra.persistence.ReservationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        ReservationEntity entity = mapper.toEntity(reservation);
        ReservationEntity newReservation = repository.save(entity);
        return mapper.toReservation(newReservation);
    }

    @Override
    public List<Reservation> listarReservas() {
        return repository.findAll().stream().map(mapper::toReservation).toList();
   }

    @Override
    public boolean salaOcupada(String sala) {
        return repository.findAll().stream()
                .anyMatch(reservation -> reservation.getSala().equalsIgnoreCase(sala));
    }

    @Override
    public Optional<Reservation> filtrarReservaPorSala(String sala) {
        return repository.findBySala(sala);
    }

    @Override
    public void deletarReserva(Long id) {
        repository.deleteById(id);
    }

    @Override
    public String gerarIdentificador() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        StringBuilder letrasGeradas = new StringBuilder(2);
        for (int i = 0; i < 2; i++) {
            letrasGeradas.append(letras.charAt(random.nextInt(letras.length())));
        }
        int numeros = 1000 + random.nextInt(9000);

        return letrasGeradas.toString() + numeros;
    }
}