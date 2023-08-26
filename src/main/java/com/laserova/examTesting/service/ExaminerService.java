package com.laserova.examTesting.service;

import com.laserova.examTesting.dto.Question;

import java.util.List;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
