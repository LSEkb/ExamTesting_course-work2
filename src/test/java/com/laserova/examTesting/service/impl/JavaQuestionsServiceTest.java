package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.QuestionAlreadyAddedException;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionsServiceTest {


    JavaQuestionsService underTest = new JavaQuestionsService();
    Question question1 = new Question("que0", "ans0");
    Question question2 = new Question("que1", "ans1");
    Question question3 = new Question("que2", "ans2");

    List<Question> questions;

    @BeforeEach
    void beforeEach() {
        questions = new ArrayList<>(Arrays.asList(question1, question2, question3));
    }

    @Test
    void addAsFields_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertEquals(question1, result);
        assertTrue(underTest.getAll().contains(question1));
    }

    @Test
    void addAsObject_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        Question result = underTest.add(question1);
        assertEquals(question1, result);
        assertTrue(underTest.getAll().contains(question1));
    }

    @Test
    void remove_removeNotExistingQuestion_thrownNotFoundQuestionsException() {
        assertThrows(QuestionNotFoundException.class, () -> underTest.remove(question1));
    }

    @Test
    void remove_removeExistingQuestion_questionsRemovedAndReturned() {
        underTest.add(question1);
        Question result = underTest.remove(question1);
        assertEquals(question1, result);
        assertFalse(underTest.getAll().contains(question1));
    }

    @Test
    void getAll_existingQuestion_returnAllQuestions() {
        underTest.add(question1);
        underTest.add(question2);
        underTest.add(question3);
        Collection<Question> result = underTest.getAll();
        assertIterableEquals(questions, result);
    }

    @Test
    void getAll_notExistingQuestion_returnEmptyCollections() {
        Collection<Question> result = underTest.getAll();
        assertIterableEquals(Collections.emptySet(), result);
    }

    @Test
    void getRandomQuestions_EmptyQuestionsSet_thrownNotFoundQuestionsException() {
        assertThrows(QuestionNotFoundException.class, () -> underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestions_NotEmptyQuestionsSet_ReturnQuestionFromQuestionsSet() {
        underTest.add(question1);
        underTest.add(question2);
        underTest.add(question3);
        Question result = underTest.getRandomQuestion();
        assertTrue(underTest.getAll().contains(result));
    }
}