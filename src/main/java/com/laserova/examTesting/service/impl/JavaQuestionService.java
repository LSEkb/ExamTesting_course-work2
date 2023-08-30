package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
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
        return javaQuestionRepository.add(question1);
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
        List<Question> questions_array = new ArrayList<>(javaQuestionRepository.getAll());
        int index = random.nextInt(questions_array.size());
        return questions_array.get(index);
    }
}
