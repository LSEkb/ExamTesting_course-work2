package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.InvalidParameterValueException;
import com.laserova.examTesting.exception.TooManyRequestsException;
import com.laserova.examTesting.service.ExaminerService;
import com.laserova.examTesting.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    Random random;

    @Autowired
    public ExaminerServiceImpl(
            @Qualifier("javaQuestionService") QuestionService javaQuestionService,
            @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.random = new Random();
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount < 0) {
            throw new InvalidParameterValueException();
        }
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new TooManyRequestsException();
        }
        Set<Question> examTicket = new HashSet<>();
        while (examTicket.size() < amount) {
            if (random.nextBoolean()) {
                examTicket.add(javaQuestionService.getRandomQuestion());
            } else {
                examTicket.add(mathQuestionService.getRandomQuestion());
            }
        }
        return examTicket;
    }
}
