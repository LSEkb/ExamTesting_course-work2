package com.laserova.examTesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Такого вопроса нет в базе вопросов")
public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException (String message) {
        super(message);
    }
}



