package com.laserova.examTesting.dto;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;


    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }


    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Question qw = (Question) other;
        return question.equals(qw.getQuestion()) && answer.equals(qw.getAnswer());
    }

    @Override
    public String toString() {
        return "Вопрос: " + question + "; " + "Ответ: " + answer + "/n";
    }
}
