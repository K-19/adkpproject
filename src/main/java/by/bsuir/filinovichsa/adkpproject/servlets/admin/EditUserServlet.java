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

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String orgName = Servlets.getStringParameter(req, "orgName");
        String orgAddress = Servlets.getStringParameter(req, "orgAddress");
        String agentName = Servlets.getStringParameter(req, "agentName");
        String agentSurname = Servlets.getStringParameter(req, "agentSurname");
        String agentPhone = Servlets.getStringParameter(req, "agentPhone");
        String description = Servlets.getStringParameter(req, "description");
        String login = Servlets.getStringParameter(req, "login");

        AbstractUser user = UserService.getInstance().findUserById(id);
        user.setNameOrganization(orgName);
        user.setAddress(orgAddress);
        user.setAgentName(agentName);
        user.setAgentSurname(agentSurname);
        user.setAgentPhone(agentPhone);
        user.setDescription(description);
        user.setLogin(login);
        String userType = Servlets.getStringParameter(req, "userType");
        AbstractUser.UserType type = AbstractUser.UserType.get(userType);
        user.setType(type);

        if (user instanceof Advertiser) {
            UserService.getInstance().updateAdvertiser((Advertiser) user);
            req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
        }
        else if (user instanceof Distributor) {
            String distributorType = Servlets.getStringParameter(req, "distributorType");
            Distributor.DistributorType distType = Distributor.DistributorType.get(distributorType);
            ((Distributor)user).setDistributorType(distType);
            UserService.getInstance().updateDistributor((Distributor) user);
            req.getRequestDispatcher("/usersPanel.jsp").forward(req, resp);
        }
    }
}
