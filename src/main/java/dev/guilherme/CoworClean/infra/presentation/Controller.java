package dev.guilherme.CoworClean.infra.presentation;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.usecases.CriarReservaCase;
import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.mapper.ReservationDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class Controller {
    private final CriarReservaCase criarReservaCase;
    private final ReservationDtoMapper reservationDtoMapper;

    public Controller(CriarReservaCase criarReservaCase, ReservationDtoMapper reservationDtoMapper) {
        this.criarReservaCase = criarReservaCase;
        this.reservationDtoMapper = reservationDtoMapper;
    }

    @PostMapping
    public ReservationDTO criarReserva(@RequestBody ReservationDTO reservationDto) {
        Reservation newReservation = criarReservaCase.execute(reservationDtoMapper.toReservation(reservationDto));
        return reservationDtoMapper.toDto(newReservation);
    }

    @GetMapping
    public String listarReservas() {
        return "Reservas";
    }
}
