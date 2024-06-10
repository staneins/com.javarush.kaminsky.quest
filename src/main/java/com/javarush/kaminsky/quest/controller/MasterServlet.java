package com.javarush.kaminsky.quest.controller;

import com.javarush.kaminsky.quest.entity.Answer;
import com.javarush.kaminsky.quest.service.QuestLogic;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "master-servlet", value = "/master")
public class MasterServlet extends HttpServlet {
    QuestLogic questLogic;
    String message;
    String answer1;
    String answer2;
    Integer nextQuestionId1;
    Integer nextQuestionId2;
    List<Answer> answers;
    String name;

    public void init() throws ServletException {
        try {
            questLogic = new QuestLogic();
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession currentSession = request.getSession();
        int questionId = getQuestionId(request);
        name = (String) currentSession.getAttribute("username");

        Integer level = (Integer) currentSession.getAttribute("level");
        if (level == null) {
            level = 1;
        }

        message = questLogic.questionView(questionId);
        answers = questLogic.getAnswers(questionId);

        if (answers.size() >= 2) {
            answer1 = answers.get(0).getAnswerText();
            answer2 = answers.get(1).getAnswerText();
            nextQuestionId1 = answers.get(0).getNextQuestionId();
            nextQuestionId2 = answers.get(1).getNextQuestionId();

            currentSession.setAttribute("level", level);
            currentSession.setAttribute("username", name);
            currentSession.setAttribute("message", message);
            currentSession.setAttribute("answer1", answer1);
            currentSession.setAttribute("answer2", answer2);
            currentSession.setAttribute("answerId1", nextQuestionId1);
            currentSession.setAttribute("nextQuestionId2", nextQuestionId2);

            if (nextQuestionId1 == 8 || nextQuestionId1 == 9) {
                level++;
                currentSession.setAttribute("level", level);
                request.getRequestDispatcher(nextQuestionId1 == 8 ? "/lose.jsp" : "/win.jsp").forward(request, response);
            } else {
                level++;
                currentSession.setAttribute("level", level);
                request.getRequestDispatcher("/quest.jsp").forward(request, response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not enough answers provided.");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        name = request.getParameter("username");
        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("username", name);
        currentSession.setAttribute("level", 1);

        message = questLogic.questionView(1);
        answers = questLogic.getAnswers(1);
        if (answers.size() >= 2) {
            answer1 = answers.get(0).getAnswerText();
            answer2 = answers.get(1).getAnswerText();
            nextQuestionId1 = answers.get(0).getNextQuestionId();
            nextQuestionId2 = answers.get(1).getNextQuestionId();

            currentSession.setAttribute("message", message);
            currentSession.setAttribute("answer1", answer1);
            currentSession.setAttribute("answer2", answer2);
            currentSession.setAttribute("answerId1", nextQuestionId1);
            currentSession.setAttribute("nextQuestionId2", nextQuestionId2);

            request.getRequestDispatcher("/quest.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not enough answers provided.");
        }
    }

    private int getQuestionId(HttpServletRequest request) {
        String click = request.getParameter("answer");
        return (click != null && click.chars().allMatch(Character::isDigit)) ? Integer.parseInt(click) : 0;
    }
}
