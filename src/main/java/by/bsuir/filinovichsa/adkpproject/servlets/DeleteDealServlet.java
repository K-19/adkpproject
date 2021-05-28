package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.services.DealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteDeal")
public class DeleteDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDeal = Integer.parseInt(req.getParameter("dealid"));
        DealService dealService = DealService.getInstance();
        AdService adService = AdService.getInstance();
        Deal deal = dealService.findById(idDeal);
        AbstractAd ad = adService.findById(deal.getAd().getId());
        dealService.delete(deal);
        adService.delete(ad);
        String owner = Servlets.getStringParameter(req, "to");
        if ("advertiser".equals(owner)) {
            Servlets.refreshAdvertiser(req);
            req.getRequestDispatcher("/dealToDistributors.jsp").forward(req, resp);
        }
        else {
            Servlets.refreshDistributor(req);
            req.getRequestDispatcher("/workWithAdvertisers.jsp").forward(req, resp);
        }
    }
}
