package dev.guilherme.CoworClean.infra.exceptions;

public class DuplicateRoomException extends RuntimeException {
  public DuplicateRoomException(String message) {
    super(message);
  }
}
