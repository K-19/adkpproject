package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.services.DealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cancelDeal")
public class CancelDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDeal = Integer.parseInt(req.getParameter("iddeal"));

        DealService service = DealService.getInstance();
        Deal deal = service.findById(idDeal);
        int index = Integer.parseInt(req.getParameter("owner"));
        if (index == 0)
            deal.setStatus(Deal.Status.DELETE_BY_DISTRIBUTOR);
        else if (index == 1)
            deal.setStatus(Deal.Status.DELETE_BY_ADVERTISER);
        service.update(deal);

        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
