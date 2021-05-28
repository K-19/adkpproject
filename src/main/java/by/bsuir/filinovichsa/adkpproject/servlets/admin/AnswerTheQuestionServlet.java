package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.services.SupportService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answerTheQuestion")
public class AnswerTheQuestionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int messageId = Integer.parseInt(req.getParameter("id"));
        String textAnswer = Servlets.getStringParameter(req, "textAnswer");

        SupportService service = SupportService.getInstance();
        SupportMessage message = service.findById(messageId);
        message.setAnswer(textAnswer);
        service.update(message);
        req.getRequestDispatcher("/techSupport.jsp").forward(req, resp);
    }
}
