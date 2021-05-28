package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.dao.DealDao;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.services.DealService;
import by.bsuir.filinovichsa.adkpproject.users.BankAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewDeal")
public class ViewDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dealId = Integer.parseInt(req.getParameter("dealId"));
        DealService service = DealService.getInstance();
        Deal deal = service.findById(dealId);
        deal.load();

        for (BankAccount account : deal.getDistributor().getBankAccounts()) {
            account.getIndividualAccount();
        }
        for (BankAccount account : deal.getProduct().getOwner().getBankAccounts()) {
            account.getIndividualAccount();
        }

        req.setAttribute("deal", deal);
        req.getRequestDispatcher("/deal.jsp").forward(req, resp);
    }
}
