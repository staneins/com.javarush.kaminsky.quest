import com.javarush.kaminsky.quest.entity.Answer;
import com.javarush.kaminsky.quest.service.QuestLogic;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuestLogicTest {
    @Test
    void questionViewTestInvalidId() {
        try {
            QuestLogic questLogic = new QuestLogic();
            String questionText = questLogic.questionView(-1);
            assertEquals("", questionText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void questionViewTest() {
        try {
            QuestLogic questLogic = new QuestLogic();
            String questionText = questLogic.questionView(1);
            assertNotNull(questionText);
            assertFalse(questionText.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAnswersTest() {
        try {
            QuestLogic questLogic = new QuestLogic();
            List<Answer> answers = questLogic.getAnswers(1);
            assertNotNull(answers);
            assertTrue(answers.size() > 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAnswersTestInvalidId() {
        try {
            QuestLogic questLogic = new QuestLogic();
            List<Answer> answers = questLogic.getAnswers(-1);
            assertNotNull(answers);
            assertFalse(answers.size() > 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
