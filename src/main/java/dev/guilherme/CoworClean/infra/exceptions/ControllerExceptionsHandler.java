package dev.guilherme.CoworClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
