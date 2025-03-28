package dev.guilherme.CoworClean.infra.presentation;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.CriarReservaUsecase;
import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.mapper.ReservationDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class Controller {
    private final CriarReservaUsecase criarReservaUsecase;
    private final BuscarReservaUsecase buscarReservaUsecase;
    private final ReservationDtoMapper reservationDtoMapper;

    public Controller(CriarReservaUsecase criarReservaUsecase, BuscarReservaUsecase buscarReservaUsecase, ReservationDtoMapper reservationDtoMapper) {
        this.criarReservaUsecase = criarReservaUsecase;
        this.buscarReservaUsecase = buscarReservaUsecase;
        this.reservationDtoMapper = reservationDtoMapper;
    }

    @PostMapping
    public ReservationDTO criarReserva(@RequestBody ReservationDTO reservationDto) {
        Reservation newReservation = criarReservaUsecase.execute(reservationDtoMapper.toReservation(reservationDto));
        return reservationDtoMapper.toDto(newReservation);
    }

    @GetMapping
    public List<ReservationDTO> listarReservas() {
        return buscarReservaUsecase.execute().stream()
                .map(reservationDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
