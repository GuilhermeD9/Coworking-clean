package dev.guilherme.CoworClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateRoomException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateRoom(DuplicateRoomException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "The room has be used, change the room.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundRoomException.class)
    public ResponseEntity<Map<String,String>> handleNotFoundRoom(NotFoundRoomException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error: ", ex.getMessage());
        response.put("Message: ", "The room was not found, check the identifier again.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotNullException.class)
    public ResponseEntity<Object> handleNullValue(NotNullException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Campos inválidos");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

/* TODO: PROXIMO DESAFIO, GERAR UM IDENTIFICADOR AUTOMATICO
 criar um usecase, implementar, criar uma função usando bibliotecas
 matemáticas para o identificador aleatorio 6 letras e randomico.
 */
