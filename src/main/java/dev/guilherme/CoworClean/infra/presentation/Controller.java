package dev.guilherme.CoworClean.infra.presentation;

import dev.guilherme.CoworClean.core.entities.Reservation;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.CriarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.DeletarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.FiltrarPorSalaUsecase;
import dev.guilherme.CoworClean.infra.dtos.ReservationDTO;
import dev.guilherme.CoworClean.infra.mapper.ReservationDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class Controller {
    private final CriarReservaUsecase criarReservaUsecase;
    private final BuscarReservaUsecase buscarReservaUsecase;
    private final FiltrarPorSalaUsecase filtrarPorSalaUsecase;
    private final DeletarReservaUsecase deletarReservaUsecase;
    private final ReservationDtoMapper reservationDtoMapper;

    public Controller(CriarReservaUsecase criarReservaUsecase, BuscarReservaUsecase buscarReservaUsecase,
                      FiltrarPorSalaUsecase filtrarPorSalaUsecase, DeletarReservaUsecase deletarReservaUsecase,
                      ReservationDtoMapper reservationDtoMapper) {
        this.criarReservaUsecase = criarReservaUsecase;
        this.buscarReservaUsecase = buscarReservaUsecase;
        this.filtrarPorSalaUsecase = filtrarPorSalaUsecase;
        this.deletarReservaUsecase = deletarReservaUsecase;
        this.reservationDtoMapper = reservationDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarReserva(@RequestBody ReservationDTO reservationDto) {
        Reservation newReservation = criarReservaUsecase.execute(reservationDtoMapper.toReservation(reservationDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Messagem: ", "Reserva cadastrada com sucesso!");
        response.put("Dados: ", reservationDtoMapper.toDto(newReservation));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<ReservationDTO> listarReservas() {
        return buscarReservaUsecase.execute().stream()
                .map(reservationDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/sala/{sala}")
    public ResponseEntity<Reservation> buscarReservaPorSala(@PathVariable String sala) {
        Reservation reservation = filtrarPorSalaUsecase.execute(sala);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReservaPorId(@PathVariable Long id) {
        deletarReservaUsecase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
