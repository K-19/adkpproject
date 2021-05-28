package by.bsuir.filinovichsa.adkpproject.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        req.setAttribute("chooseRole", role);
        req.setAttribute("role", role);
        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
    }
}
