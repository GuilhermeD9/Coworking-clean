package dev.guilherme.CoworClean.infra.config;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaCase;
import dev.guilherme.CoworClean.core.usecases.BuscarReservaCaseImpl;
import dev.guilherme.CoworClean.core.usecases.CriarReservaCase;
import dev.guilherme.CoworClean.core.usecases.CriarReservaCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarReservaCase criarReserva(ReservationGateway gateway) {
        return new CriarReservaCaseImpl(gateway);
    }

    @Bean
    public BuscarReservaCase buscarReserva(ReservationGateway gateway) {
        return new BuscarReservaCaseImpl(gateway);
    }
}
