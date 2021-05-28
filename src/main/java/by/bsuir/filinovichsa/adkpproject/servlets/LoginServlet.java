package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.AdminService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Admin;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = Servlets.getStringParameter(req, "login");
        String password = Servlets.getStringParameter(req, "password");

        Admin admin = AdminService.getInstance().findByLoginAndPassword(login, password.hashCode());
        if (admin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", admin);
            req.getRequestDispatcher("/adminMain.jsp").forward(req, resp);
            return;
        }

        System.out.println("pirog".hashCode());
        UserService service = UserService.getInstance();
        AbstractUser user = service.findUserByLoginAndPassword(login, password.hashCode());

        if (user != null) {
            HttpSession session = req.getSession();
            if (user instanceof Advertiser)
                session.setAttribute("user", (Advertiser) user);
            else if (user instanceof Distributor)
                session.setAttribute("user", (Distributor) user);
            req.getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Указаны неправильные логин и пароль");
            req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        }
    }
}
