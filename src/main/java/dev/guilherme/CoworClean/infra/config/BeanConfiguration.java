package dev.guilherme.CoworClean.infra.config;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarReservaUsecase criarReserva(ReservationGateway gateway) {
        return new CriarReservaUsecaseImpl(gateway);
    }

    @Bean
    public BuscarReservaUsecase buscarReserva(ReservationGateway gateway) {
        return new BuscarReservaUsecaseImpl(gateway);
    }

    @Bean
    public FiltroSalaUsecase filtrarSala(ReservationGateway gateway) {
        return new FiltroSalaUsecaseImpl(gateway);
    }
}
