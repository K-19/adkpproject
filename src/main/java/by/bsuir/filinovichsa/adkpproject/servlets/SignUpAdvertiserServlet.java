package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/signUpAdvertiser")
public class SignUpAdvertiserServlet extends HttpServlet {
    private String errorPage = "signUp.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AbstractUser.UserType orgType = Servlets.getUserType(req, "userAdvertiserType", errorPage);
            if (orgType == null) {
                req.getRequestDispatcher(errorPage).forward(req, resp);
                return;
            }
            String orgName = Servlets.getStringParameter(req, "advertiserOrgName");
            String orgAddress = Servlets.getStringParameter(req, "advertiserOrgAddress");
            String agentName = Servlets.getStringParameter(req, "advertiserAgentName");
            String agentSurname = Servlets.getStringParameter(req, "advertiserAgentSurname");
            String agentPhone = Servlets.getStringParameter(req, "advertiserAgentPhone");
            String description = Servlets.getStringParameter(req, "advertiserDescription");
            String login = Servlets.getStringParameter(req, "advertiserLogin");
            String password = Servlets.getStringParameter(req, "advertiserPassword");

            List<Advertiser> list = UserService.getInstance().findAllAdvertisers();
            for (Advertiser advertiser : list) {
                if (advertiser.getLogin().equals(login))
                    throw new Exception("Указанный логин занят другим пользователем");
            }

            Advertiser advertiser = new Advertiser(orgType, orgName, description, orgAddress, agentName, agentSurname, agentPhone, login, password.hashCode());
            UserService service = UserService.getInstance();
            service.saveAdvertiser(advertiser);
            req.setAttribute("error", "Пользователь успешно зарегистрирован!");
            req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
    }
}
