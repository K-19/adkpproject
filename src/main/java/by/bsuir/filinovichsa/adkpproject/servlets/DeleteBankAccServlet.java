package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.services.BankAccService;
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

@WebServlet("/deleteBankAcc")
public class DeleteBankAccServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAcc = Integer.parseInt(req.getParameter("accid"));

        BankAccService service = BankAccService.getInstance();
        BankAccount account = service.findById(idAcc);
        service.delete(account);

        AbstractUser user = (AbstractUser) req.getSession(false).getAttribute("user");
        user.removeBankAccount(account);
        if (user instanceof Advertiser) {
            Servlets.refreshAdvertiser(req);
        }
        if (user instanceof Distributor) {
            Servlets.refreshDistributor(req);
        }
        req.getRequestDispatcher("/bankAccounts.jsp").forward(req, resp);
    }
}
