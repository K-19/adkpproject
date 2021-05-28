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

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AbstractUser user = UserService.getInstance().findUserById(id);

        if (user instanceof Advertiser) {
            UserService.getInstance().deleteAdvertiser((Advertiser) user);
            req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
        }
        else if (user instanceof Distributor) {
            UserService.getInstance().deleteDistributor((Distributor) user);
            req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
        }
    }
}
