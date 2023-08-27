package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.TooManyRequestsException;
import com.laserova.examTesting.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    private static Collection<Question> questionsTest() {
        return List.of(
                new Question("que1", "ans1"),
                new Question("que2", "ans2"),
                new Question("que3", "ans3"),
                new Question("que4", "ans4"),
                new Question("que5", "ans5")
        );
    }

    @Test
    void qetQuestions_amountMoreSize_thrownTooManyRequestException() {
        when(questionService.getAll()).thenReturn(questionsTest());
        assertThrows(TooManyRequestsException.class, () -> underTest.getQuestions(10));
    }

//    @Test
//    void qetQuestions_amountNoMoreSize_returnSetOfRandomQuestions() {
//        when(questionService.getAll()).thenReturn(questionsTest());
//        Set<Question> result1 = underTest.getQuestions(3);
//        Set<Question> result2 = underTest.getQuestions(3);
//        assertNotEquals(result2, result1);
//    }
}