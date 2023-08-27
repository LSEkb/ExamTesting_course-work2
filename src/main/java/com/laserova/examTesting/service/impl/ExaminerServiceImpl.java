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

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> examTicket = new HashSet<>();
        if (amount>questionService.getAll().size()){
            throw new TooManyRequestsException("Количество вопросов в базе меньше затребованного для билета");
        }
            do {
                examTicket.add(questionService.getRandomQuestion());
            } while (examTicket.size() < amount);
        return examTicket;
    }
}
