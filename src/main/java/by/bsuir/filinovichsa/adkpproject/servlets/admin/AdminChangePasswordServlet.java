package by.bsuir.filinovichsa.adkpproject.servlets.admin;

import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.servlets.Servlets;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminChangePassword")
public class AdminChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newPass = Servlets.getStringParameter(req, "newPassword");
        String repeatPass = Servlets.getStringParameter(req, "repeatNewPassword");

        if (newPass.equals(repeatPass)) {
            AbstractUser user = UserService.getInstance().findUserById(id);
            user.setPassword(newPass.hashCode());
            if (user instanceof Advertiser) {
                UserService.getInstance().updateAdvertiser((Advertiser) user);
            }
            if (user instanceof Distributor) {
                UserService.getInstance().updateDistributor((Distributor) user);
            }
            req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("editUserPage?id=" + id).forward(req, resp);
        }

    }
}
