package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.service.QuestionService;

import java.util.*;

public class JavaQuestionsService implements QuestionService {
    List<Question> questions = new ArrayList<>();
    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question1) {
        questions.add(question1);
        return question1;
    }

    @Override
    public Question remove(Question question1) {
        questions.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random rdm = new Random();
        int index = rdm.nextInt(questions.size());
       return questions.get(index);
    }
}
