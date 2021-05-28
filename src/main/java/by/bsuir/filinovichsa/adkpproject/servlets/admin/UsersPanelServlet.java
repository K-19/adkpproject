package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usersPanel")
public class UsersPanelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filter = Servlets.getStringParameter(req, "filter");
        req.setAttribute("filter", filter);
        req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
    }
}
