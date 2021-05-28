package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.SupportService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.support.SupportMessage;
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

@WebServlet("/sendTechMessage")
public class SendTechMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AbstractUser user = (AbstractUser) req.getSession(false).getAttribute("user");

            String text = Servlets.getStringParameter(req, "textMessage");
            SupportMessage message = new SupportMessage(user, text);
            user.addSupportMessage(message);
            UserService service = UserService.getInstance();
            if (user instanceof Advertiser)
                service.updateAdvertiser((Advertiser) user);
            else if (user instanceof Distributor)
                service.updateDistributor((Distributor) user);

            req.getRequestDispatcher("support.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/support.jsp").forward(req, resp);
        }
    }
}
