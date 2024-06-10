package com.javarush.kaminsky.quest.entity;

public class Answer {
    String answerText;
    Integer nextQuestionId;

    public Answer(Integer id, String answerText) {
        this.nextQuestionId = id;
        this.answerText = answerText;
    }

    public Answer() {
    }

    public Integer getNextQuestionId() {
        return nextQuestionId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setNextQuestionId(Integer id) {
        this.nextQuestionId = id;
    }
}