package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.TooManyRequestsException;
import com.laserova.examTesting.service.ExaminerService;
import com.laserova.examTesting.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {
    QuestionService questionService;

    @Override
    public Set<Question> getQuestions(int amount) throws TooManyRequestsException {
        Set<Question> examTicket = new HashSet<>();
        try {
            do {
                examTicket.add(questionService.getRandomQuestion());
            } while (examTicket.size() < amount);
        } catch (TooManyRequestsException ex) {
            System.out.println(ex.getMessage());
        }
        return examTicket;
    }
}
