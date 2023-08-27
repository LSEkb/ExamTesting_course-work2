package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.QuestionAlreadyAddedException;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionsServiceTest {

    JavaQuestionsService underTest = new JavaQuestionsService();
    Question question1 = new Question("que1", "ans1");
    Question question2 = new Question("que2", "ans2");
    Question question3 = new Question("que3", "ans3");
    Question question4 = new Question("que4", "ans4");
    Question question5 = new Question("que5", "ans5");
    Question question6 = new Question("que6", "ans6");

    List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3, question4, question5));
    int n = 5;

    @Test
    void addAsFields_addedRepeatedQuestionsAndAnswer_thrownAlreadyAddedQuestionsException() {
        for (int i = 0; i < n; i++) {
            underTest.add("que" + String.valueOf(i), "ans" + String.valueOf(i));
        }
        assertThrows(QuestionAlreadyAddedException.class, () -> underTest.add("que1",
                "ans1"));
    }

    @Test
    void addAsFields_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        Question result = underTest.add(question1.getQuestion(), question1.getAnswer());
        assertEquals(question1, result);
        assertTrue(underTest.getAll().contains(question1));
    }

    @Test
    void addAsObject_addedRepeatedQuestionsAndAnswer_thrownQuestionAlreadyAddedException() {
        underTest.add(question1);
        assertThrows(QuestionAlreadyAddedException.class, () -> underTest.add(question1));
    }

    @Test
    void addAsObject_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        Question result = underTest.add(question1);
        assertEquals(question1, result);
        assertTrue(underTest.getAll().contains(question1));
    }

        @Test
    void remove_removeNoExistingQuestion_thrownNotFoundQuestionsException()  {
            assertThrows(QuestionNotFoundException.class, () -> underTest.remove(question1));
    }

    @Test
    void remove_removeExistingQuestion_questionsAddedAndReturned() {
        underTest.add(question1);
        Question result = underTest.remove(question1);
        assertEquals(question1, result);
        assertFalse(underTest.getAll().contains(question1));
    }

    @Test
    void getAll_existingQuestion_returnAllQuestions() {

    }

    @Test
    void getAll_noExistingQuestion_returnEmptyCollections() {

    }

    @Test
    void getRandomQuestions_noExistingQuestion_returnEmptyCollections() {

    }
}