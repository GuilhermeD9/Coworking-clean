package dev.guilherme.CoworClean.infra.presentation;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaCase;
import dev.guilherme.CoworClean.core.usecases.CriarReservaCase;
import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.mapper.ReservationDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class Controller {
    private final CriarReservaCase criarReservaCase;
    private final BuscarReservaCase buscarReservaCase;
    private final ReservationDtoMapper reservationDtoMapper;

    public Controller(CriarReservaCase criarReservaCase, BuscarReservaCase buscarReservaCase, ReservationDtoMapper reservationDtoMapper) {
        this.criarReservaCase = criarReservaCase;
        this.buscarReservaCase = buscarReservaCase;
        this.reservationDtoMapper = reservationDtoMapper;
    }

    @PostMapping
    public ReservationDTO criarReserva(@RequestBody ReservationDTO reservationDto) {
        Reservation newReservation = criarReservaCase.execute(reservationDtoMapper.toReservation(reservationDto));
        return reservationDtoMapper.toDto(newReservation);
    }

    @GetMapping
    public List<ReservationDTO> listarReservas() {
        List<Reservation> reservations = buscarReservaCase.execute();
        return reservationDtoMapper.listResrvationToDto(reservations);
    }
}
