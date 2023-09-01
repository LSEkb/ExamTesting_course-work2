package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import com.laserova.examTesting.repository.JavaQuestionRepository;
import com.laserova.examTesting.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final JavaQuestionRepository javaQuestionRepository;
    Random random;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.random = new Random();

    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        return this.add(question1);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestionRepository.getAll().isEmpty()){
            throw new QuestionNotFoundException();
        }
        return new ArrayList<>(javaQuestionRepository.getAll()).get(random.nextInt(javaQuestionRepository.getAll().size()));
    }
}
