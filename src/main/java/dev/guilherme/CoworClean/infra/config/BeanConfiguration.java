package dev.guilherme.CoworClean.infra.config;

import dev.guilherme.CoworClean.core.getaway.ReservationGateway;
import dev.guilherme.CoworClean.core.usecases.CriarReservaCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarReservaCaseImpl reservaCase(ReservationGateway gateway) {
        return new CriarReservaCaseImpl(gateway);
    }
}
