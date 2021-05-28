package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fullUserInfo")
public class FullUserInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AbstractUser user = UserService.getInstance().findUserById(id);

        if (user instanceof Advertiser) {
            req.setAttribute("usser", (Advertiser) user);
            req.getRequestDispatcher("/fullUserInfo.jsp").forward(req, resp);
        }
        else if (user instanceof Distributor) {
            req.setAttribute("usser", (Distributor) user);
            req.getRequestDispatcher("/fullUserInfo.jsp").forward(req, resp);
        }
    }
}
