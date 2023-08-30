package com.laserova.examTesting.service.impl;

import com.laserova.examTesting.dto.Question;
import com.laserova.examTesting.exception.QuestionAlreadyAddedException;
import com.laserova.examTesting.exception.QuestionNotFoundException;
import com.laserova.examTesting.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionsServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    JavaQuestionService underTest;

    Question question1 = new Question("que0", "ans0");
    Question question2 = new Question("que1", "ans1");
    Question question3 = new Question("que2", "ans2");

    private  Set<Question> questions() {
        return new HashSet<>(Arrays.asList(question1, question2));
    }

    @Test
    void addAsField_addedRepeatedQuestionsAndAnswer_thrownQuestionAlreadyAddedException() {
        when(underTest.add(question3.getQuestion(), question3.getAnswer())).thenReturn(question3);
        underTest.add(question3.getQuestion(), question3.getAnswer());
        assertThrows(QuestionAlreadyAddedException.class, () -> underTest.add(question3.getQuestion(), question3.getAnswer()));
    }

    @Test
    void addAsFields_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        when(underTest.add(question3.getQuestion(), question3.getAnswer())).thenReturn(question3);
        Question result = underTest.add(question3.getQuestion(), question3.getAnswer());
        assertEquals(question3, result);
        assertTrue(underTest.getAll().contains(question3));
    }

    @Test
    void addAsObject_addedRepeatedQuestionsAndAnswer_thrownQuestionAlreadyAddedException() {
        when(underTest.add(question3)).thenReturn(question3);
        underTest.add(question3);
        assertThrows(QuestionAlreadyAddedException.class, () -> underTest.add(question3));

    }

    @Test
    void addAsObject_addedNewQuestionsAndAnswer_questionsAddedAndReturned() {
        when(underTest.add(question3)).thenReturn(question3);
        Question result = underTest.add(question3);
        assertEquals(question3, result);
        assertTrue(underTest.getAll().contains(question3));
    }

    @Test
    void remove_removeNotExistingQuestion_thrownNotFoundQuestionsException() {
        when(underTest.remove(question3)).thenReturn(question3);
        underTest.remove(question3);
        assertThrows(QuestionNotFoundException.class, () -> underTest.remove(question3));
    }

    @Test
    void remove_removeExistingQuestion_questionsRemovedAndReturned() {
        when(underTest.remove(question2)).thenReturn(question2);
        underTest.remove(question2);
        Question result = underTest.remove(question2);
        assertEquals(question2, result);
        assertFalse(questions().contains(question2));
    }

    @Test
    void getAll_existingQuestion_returnAllQuestions() {
        when(underTest.add(question1)).thenReturn(question1);
        when(underTest.add(question2)).thenReturn(question2);
        underTest.add(question1);
        underTest.add(question2);

        Collection<Question> result = underTest.getAll();
        assertIterableEquals(questions(), result);
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
        when(javaQuestionRepository.getAll()).thenReturn(questions());
//        underTest.add(question1);
//        underTest.add(question2);
//        underTest.add(question3);
        Question result = underTest.getRandomQuestion();
        assertTrue(underTest.getAll().contains(result));
    }
}


