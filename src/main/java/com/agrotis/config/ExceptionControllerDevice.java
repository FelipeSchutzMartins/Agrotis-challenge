package com.agrotis.config;

import com.agrotis.exceptions.AgrotisException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

@RestControllerAdvice
class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, ArrayList> handleValidationExceptions(MethodArgumentNotValidException ex) {
        var messages = new HashSet<>();
        ex.getBindingResult().getAllErrors().forEach(it -> messages.add(it.getDefaultMessage()));
        return Map.of("erros", new ArrayList<>(messages));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AgrotisException.class)
    public Map<String, String> handleAgrotisExceptions(AgrotisException ex) {
        return Map.of("error", ex.getMessage());
    }

}
