package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.services.AdminService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;
import by.bsuir.filinovichsa.adkpproject.users.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/addAdmin")
public class AddAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("addAdmin", true);
        req.getRequestDispatcher("adminsPanel.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = Servlets.getStringParameter(req, "name");
            String surname = Servlets.getStringParameter(req, "surname");
            String login = Servlets.getStringParameter(req, "login");
            String pass = Servlets.getStringParameter(req, "password");
            String repeatPass = Servlets.getStringParameter(req, "repeatPassword");

            if (pass.equals(repeatPass)) {
                List<Admin> admins = ((Admin)req.getSession(false).getAttribute("user")).getAllAdmins();
                for (Admin admin : admins) {
                    if (admin.getLogin().equals(login))
                        throw new Exception("Логин уже занят другим администратором");
                }
                Admin newAdmin = new Admin(name, surname, login, pass.hashCode(), LocalDateTime.now());
                AdminService.getInstance().save(newAdmin);
                throw new Exception("Администратор " + name + " " + surname + " добавлен");
            } else {
                throw new Exception("Пароли не совпадают");
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/adminsPanel.jsp").forward(req, resp);
        }
    }
}
