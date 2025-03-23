package dev.guilherme.CoworClean.infra.persistence;

import dev.guilherme.CoworClean.core.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String sala;
    String locador;
    LocalDateTime inicio;
    LocalDateTime fim;
    @Enumerated(EnumType.STRING)
    Status status;

    public ReservationEntity(Long id, String sala, String locador, LocalDateTime inicio, LocalDateTime fim, Status status) {
        this.id = id;
        this.sala = sala;
        this.locador = locador;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
    }

    public ReservationEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getLocador() {
        return locador;
    }

    public void setLocador(String locador) {
        this.locador = locador;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
