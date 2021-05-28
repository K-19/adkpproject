package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addBankAccount")
public class AddBankAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("addAccount", true);
        req.getRequestDispatcher("bankAccounts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BankAccount.CountryCode countryCode = BankAccount.CountryCode.valueOf(Servlets.getStringParameter(req, "countryCode"));
            String checkNumber = Servlets.getStringParameter(req, "checkNumber");
            int test = Integer.parseInt(checkNumber);
            String bankBICCode = Servlets.getStringParameter(req, "bankBICCode");
            String balanceAccount = Servlets.getStringParameter(req, "balanceAccount");
            test = Integer.parseInt(balanceAccount);
            String individualAccount = Servlets.getStringParameter(req, "individualAccount");
            long testt = Long.parseLong(individualAccount);
            String bankBranchName = Servlets.getStringParameter(req, "bankBranchName");
            String bankBranchAddress = Servlets.getStringParameter(req, "bankBranchAddress");

            AbstractUser user = (AbstractUser) req.getSession(false).getAttribute("user");

            BankAccount newBankAccount = new BankAccount(user, countryCode, checkNumber, bankBICCode, balanceAccount, individualAccount, bankBranchName, bankBranchAddress);

            user.addBankAccount(newBankAccount);

            UserService service = UserService.getInstance();
            if (user instanceof Advertiser)
                service.updateAdvertiser((Advertiser) user);
            else if (user instanceof Distributor)
                service.updateDistributor((Distributor) user);

            req.getRequestDispatcher("bankAccounts.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("bankAccounts.jsp").forward(req, resp);
        }
    }
}
