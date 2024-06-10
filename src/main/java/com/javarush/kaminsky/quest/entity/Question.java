package com.javarush.kaminsky.quest.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    Integer id;
    String questionText;
    List<Answer> answers = new ArrayList<>();

    public Question(Integer id, String questionText, List<Answer> answers) {
        this.id = id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public Question(){
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Integer getId() {
        return id;
    }

}