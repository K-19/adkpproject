package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUpDistributor")
public class SignUpDistributorServlet extends HttpServlet {
    private String errorPage = "signUp.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        AbstractUser.UserType orgType = Servlets.getUserType(req, "userDistributorType", errorPage);
        if (orgType == null) {
            req.getRequestDispatcher(errorPage).forward(req, resp);
            return;
        }
        String distributorType = Servlets.getStringParameter(req, "distributorType");
        Distributor.DistributorType distType = null;
        switch(distributorType) {
            case "Газета": distType = Distributor.DistributorType.NEWSPAPER; break;
            case "Журнал": distType = Distributor.DistributorType.MAGAZINE; break;
            case "Интернет-портал": distType = Distributor.DistributorType.INTERNET_PORTAL; break;
            case "Радиостанция": distType = Distributor.DistributorType.RADIO_STATION; break;
            case "ТВ-канал": distType = Distributor.DistributorType.TV_CHANNEL; break;
            case "Другое": distType = Distributor.DistributorType.OTHER; break;
            default:
                req.getRequestDispatcher(errorPage).forward(req, resp);
                return;
        }
        String orgName = Servlets.getStringParameter(req, "distributorOrgName");
        String orgAddress = Servlets.getStringParameter(req, "distributorOrgAddress");
        String agentName = Servlets.getStringParameter(req, "distributorAgentName");
        String agentSurname = Servlets.getStringParameter(req, "distributorAgentSurname");
        String agentPhone = Servlets.getStringParameter(req, "distributorAgentPhone");
        String description = Servlets.getStringParameter(req, "distributorDescription");
        String login = Servlets.getStringParameter(req, "distributorLogin");
        String password = Servlets.getStringParameter(req, "distributorPassword");

        if (!Servlets.allNotEmpty(orgName, orgAddress, agentName, agentSurname, agentPhone, description, login, password)) {
            req.getRequestDispatcher(errorPage).forward(req, resp);
            return;
        }
        //TODO: Добавить нормальных проверок на вводимые данные

        Distributor distributor = new Distributor(distType, orgType, orgName, description, orgAddress, agentName, agentSurname, agentPhone, login, password.hashCode());
        System.out.println(distributor);
        UserService service = UserService.getInstance();
        service.saveDistributor(distributor);

        req.getRequestDispatcher("hello.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        }
    }
}
