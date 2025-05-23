package dev.guilherme.CoworClean.infra.config;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarReservaUsecase criarReserva(ReservationGateway gateway, IdentificadorSalaUsecase usecase) {
        return new CriarReservaUsecaseImpl(gateway, usecase);
    }

    @Bean
    public BuscarReservaUsecase buscarReserva(ReservationGateway gateway) {
        return new BuscarReservaUsecaseImpl(gateway);
    }

    @Bean
    public FiltrarPorSalaUsecase filtrarSala(ReservationGateway gateway) {
        return new FiltrarPorSalaUsecaseImpl(gateway);
    }

    @Bean
    public DeletarReservaUsecase deletarReserva(ReservationGateway gateway) {
        return new DeletarReservaUsecaseImpl(gateway);
    }

    @Bean
    public IdentificadorSalaUsecase gerarIdSala(ReservationGateway gateway) {
        return new IdentificadorSalaUsecaseImpl(gateway);
    }
}
