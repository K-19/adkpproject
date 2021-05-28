package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.factories.AdFactory;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.services.DealService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sendDealToDist")
public class SendDealToDistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.removeAttribute("distributor");
        req.getRequestDispatcher("/chooseDistributor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            Distributor distributor = (Distributor) session.getAttribute("distributor");
            Product product = (Product) session.getAttribute("product");
            Object[] parameters = Servlets.readAdByRequest(req, product.getAdType());
            AdFactory factory = new AdFactory();
            AbstractAd abstractAd = factory.createAd(product.getAdType(), parameters);
            AdService adService = AdService.getInstance();
            adService.save(abstractAd);
            String comment = Servlets.getStringParameter(req, "comment");
            Deal deal = new Deal(product, abstractAd, distributor, Deal.Status.TO_DISTRIBUTOR, comment);
            deal.getAd().setDeal(deal);
            DealService dealService = DealService.getInstance();
            dealService.save(deal);
            deal = dealService.findById(deal.getId());
            Servlets.refreshAdvertiser(req);
            deal.load();
            req.setAttribute("deal", deal);
            req.getRequestDispatcher("/deal.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
        }
    }
}
