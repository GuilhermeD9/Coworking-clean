package dev.guilherme.CoworClean.infra.exceptions;

public class NotFoundRoomException extends RuntimeException {
    public NotFoundRoomException(String message) {
        super(message);
    }
}
