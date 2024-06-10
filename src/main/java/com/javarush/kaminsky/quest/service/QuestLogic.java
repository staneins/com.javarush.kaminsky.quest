package com.javarush.kaminsky.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.javarush.kaminsky.quest.entity.Answer;
import com.javarush.kaminsky.quest.entity.Question;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class QuestLogic {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File fileName = new File("/run/media/philipk/68220e73-ac0a-41b6-b3bb-cb3b9497ba49/git/com.javarush.kaminsky.quest/src/main/resources/quest.json");

    List<Question> questionList = mapper.readValue(fileName, new TypeReference<List<Question>>() {
    });


    public QuestLogic() throws IOException {
    }

    public String questionView(Integer id) {
        return questionList.stream()
                .filter(question -> question.getId().equals(id))
                .map(Question::getQuestionText)
                .findFirst()
                .orElse("");
    }

    public List<Answer> getAnswers(Integer questionId) {
        return questionList.stream()
                .filter(question -> question.getId().equals(questionId))
                .flatMap(question -> question.getAnswers().stream())
                .collect(Collectors.toList());
    }
}

