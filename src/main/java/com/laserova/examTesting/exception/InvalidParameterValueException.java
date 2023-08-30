package com.laserova.examTesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Количество вопросов в билете не может быть задано отрицательным числом")
    public class InvalidParameterValueException extends RuntimeException{
}
