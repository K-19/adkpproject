package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.services.AdminService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Admin;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeAdminPassword")
public class ChangeAdminPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changeAdminPassword", true);
        req.getRequestDispatcher("adminMain.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String oldPass = Servlets.getStringParameter(req, "oldPass");
            String newPass = Servlets.getStringParameter(req, "newPass");
            String repeatNewPass = Servlets.getStringParameter(req, "repeatNewPass");

            Admin user = (Admin) req.getSession(false).getAttribute("user");

            if(oldPass.hashCode() == user.getPassword()) {
                if (newPass.equals(repeatNewPass)) {
                    user.setPassword(newPass.hashCode());
                    AdminService service = AdminService.getInstance();
                    service.update(user);
                    throw new Exception("Пароль изменён");
                } else {
                    throw new Exception("Пароли не совпадают");
                }
            } else {
                throw new Exception("Старый пароль неправильный");
            }
        } catch (Exception e) {
            req.setAttribute("resultChanging", e.getMessage());
            req.setAttribute("changeAdminPassword", true);
            req.getRequestDispatcher("/adminMain.jsp").forward(req, resp);
        }
    }
}
