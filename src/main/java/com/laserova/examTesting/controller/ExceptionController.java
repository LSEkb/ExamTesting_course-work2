package com.laserova.examTesting.controller;

import com.laserova.examTesting.exception.QuestionAlreadyAddedException;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import com.laserova.examTesting.exception.TooManyRequestsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({QuestionAlreadyAddedException.class, TooManyRequestsException.class, QuestionNotFoundException.class})
    public ResponseEntity<String> handleException(Exception error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Получена ошибка: " + error.getMessage());
    }
}


