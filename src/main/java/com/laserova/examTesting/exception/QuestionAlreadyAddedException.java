package com.laserova.examTesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Такой вопрос уже есть в базе вопросов")
public class QuestionAlreadyAddedException extends RuntimeException {
}
