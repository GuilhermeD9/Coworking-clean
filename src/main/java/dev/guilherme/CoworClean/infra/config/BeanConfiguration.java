package dev.guilherme.CoworClean.infra.config;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaUsecaseImpl;
import dev.guilherme.CoworClean.core.usecases.CriarReservaUsecase;
import dev.guilherme.CoworClean.core.usecases.CriarReservaUsecaseImpl;
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
}
