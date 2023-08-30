package com.laserova.examTesting.repository;

import com.laserova.examTesting.dto.Question;

import java.util.Collection;

public interface QuestionsRepository {
    Question add (Question question);
    Question remove (Question question);
    Collection<Question> getAll();
}
