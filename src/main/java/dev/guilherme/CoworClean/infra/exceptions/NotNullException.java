package dev.guilherme.CoworClean.infra.exceptions;

public class NotNullException extends RuntimeException {
    public NotNullException(String message) {
        super(message);
    }
}
