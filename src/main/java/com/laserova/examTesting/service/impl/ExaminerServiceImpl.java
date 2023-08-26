package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.TooManyRequestsException;
import com.laserova.examTesting.service.ExaminerService;
import com.laserova.examTesting.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService){
        this.questionService = questionService;
    }

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
