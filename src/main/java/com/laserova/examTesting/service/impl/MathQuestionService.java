package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.repository.MathQuestionRepository;
import com.laserova.examTesting.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
@Service
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;
    Random random;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return mathQuestionRepository.add(question1);
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        ArrayList<Question> questions_array = new ArrayList<>(mathQuestionRepository.getAll());
        int index = random.nextInt(questions_array.size());
        return questions_array.get(index);
    }
}
