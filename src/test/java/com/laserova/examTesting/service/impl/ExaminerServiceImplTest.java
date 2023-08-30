package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.InvalidParameterValueException;
import com.laserova.examTesting.exception.TooManyRequestsException;
import com.laserova.examTesting.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    @Qualifier("javaQuestionService")
    QuestionService javaQuestionService;
    @Mock
    @Qualifier("mathQuestionService")
    QuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    private static Collection<Question> questionsJava() {
        return List.of(
                new Question("qj1", "aj1"),
                new Question("qj2", "aj2"),
                new Question("qj3", "aj3")
        );
    }
    private static Collection<Question> questionsMath() {
        return List.of(
                new Question("qm1", "am1"),
                new Question("qm2", "am2"),
                new Question("qm3", "am3")
        );
    }

    @Test
    void qetQuestions_amountMoreSize_thrownTooManyRequestException() {
        when(javaQuestionService.getAll()).thenReturn(questionsJava());
        when(mathQuestionService.getAll()).thenReturn(questionsMath());

        assertThrows(TooManyRequestsException.class, () -> underTest.getQuestions(10));
    }

    @Test
    void qetQuestions_amountLessZero_thrownInvalidParameterValueException() {
        when(javaQuestionService.getAll()).thenReturn(questionsJava());
        when(mathQuestionService.getAll()).thenReturn(questionsMath());

        assertThrows(InvalidParameterValueException.class, () -> underTest.getQuestions(-2));
    }

//    @Test
//    void qetQuestions_amountNoMoreSize_returnSetOfRandomQuestions() {
//        when(questionService.getAll()).thenReturn(questionsTest());
//        when(questionService.getRandomQuestion()).thenReturn(new Question("que1", "ans1"))
//        .thenReturn(new Question("que2", "ans2"))
//        .thenReturn(new Question("que2", "ans2"))
//        .thenReturn(new Question("que4", "ans4"))
//        .thenReturn(new Question("que3", "ans3"));
//        Set<Question> result = underTest.getQuestions(3);
//        Set<Question> expected = new HashSet<>(List.of(
//                new Question("que1", "ans1"),
//                new Question("que2", "ans2"),
//                new Question("que4", "ans4")
//        ));
//        assertEquals(expected, result);
//    }
}