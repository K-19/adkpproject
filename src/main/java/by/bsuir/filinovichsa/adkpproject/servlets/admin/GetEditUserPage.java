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

@WebServlet("/editUserPage")
public class GetEditUserPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AbstractUser user = UserService.getInstance().findUserById(id);

        if (user instanceof Advertiser) {
            req.setAttribute("object", (Advertiser) user);
            req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
        }
        else if (user instanceof Distributor) {
            req.setAttribute("object", (Distributor) user);
            req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
        }
    }
}
