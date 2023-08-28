package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.QuestionAlreadyAddedException;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import com.laserova.examTesting.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionsService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionsService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questions.contains(question1)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть в базе вопросов");
        }
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question1) {
        if (questions.contains(question1)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть в базе вопросов");
        }
        questions.add(question1);
        return question1;
    }

    @Override
    public Question remove(Question question1) {
        if (!questions.contains(question1)) {
            throw new QuestionNotFoundException("Такого вопроса нет в базе вопросов");
        }
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
        ArrayList<Question> questions_array = new ArrayList<>(questions);
        return questions_array.get(index);
    }
}
