package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePassword", true);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String oldPass = Servlets.getStringParameter(req, "oldPass");
            String newPass = Servlets.getStringParameter(req, "newPass");
            String repeatNewPass = Servlets.getStringParameter(req, "repeatNewPass");

            AbstractUser user = (AbstractUser) req.getSession(false).getAttribute("user");

            if(oldPass.hashCode() == user.getPassword()) {
                if (newPass.equals(repeatNewPass)) {
                    user.setPassword(newPass.hashCode());
                    UserService service = UserService.getInstance();
                    if (user instanceof Advertiser)
                        service.updateAdvertiser((Advertiser) user);
                    else if (user instanceof Distributor)
                        service.updateDistributor((Distributor) user);
                    throw new Exception("Пароль изменён");
                } else {
                    throw new Exception("Пароли не совпадают");
                }
            } else {
                throw new Exception("Старый пароль неправильный");
            }
        } catch (Exception e) {
            req.setAttribute("resultChanging", e.getMessage());
            req.setAttribute("changePassword", true);
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }
}
