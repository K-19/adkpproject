package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.*;
import by.bsuir.filinovichsa.adkpproject.factories.AdFactory;
import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.services.AdService;
import by.bsuir.filinovichsa.adkpproject.services.DealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/confirmDeal")
public class ConfirmDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int index = Integer.parseInt(req.getParameter("index"));
            if (req.getParameter("edit") != null) {
                int idAd;
                Deal deal = (Deal) req.getSession(false).getAttribute("deal");
                idAd = deal.getAd().getId();
                switch(deal.getProduct().getAdType()) {
                    case AIRSHIP: AirshipAd.getAndSave(req, idAd);
                        break;
                    case BALLOON: BalloonAd.getAndSave(req, idAd);
                        break;
                    case BROADCAST: BroadcastingAd.getAndSave(req, idAd);
                        break;
                    case MEDIA_PRINTED: MediaPrintedAd.getAndSave(req, idAd);
                        break;
                    case OTH_PRINTED: OthPrintedAd.getAndSave(req, idAd);
                        break;
                    case MEDIAN_NET: MediaNetAd.getAndSave(req, idAd);
                        break;
                    case SOUVENIR: SouvenirAd.getAndSave(req, idAd);
                        break;
                    case INTERNET: InternetAd.getAndSave(req, idAd);
                        break;
                    case OUTDOOR: OutdoorAd.getAndSave(req, idAd);
                        break;
                    case EVENT: EventAd.getAndSave(req, idAd);
                }
                if (index == 0)
                    deal.setStatus(Deal.Status.TO_ADVERTISER);
                else if (index == 1)
                    deal.setStatus(Deal.Status.TO_DISTRIBUTOR);
                String comment = Servlets.getStringParameter(req, "comment");
                deal.setComment(comment);
                DealService dealService = DealService.getInstance();
                dealService.update(deal);
            } else {
                Deal deal = (Deal) req.getSession(false).getAttribute("deal");
                deal.setStatus(Deal.Status.CONFIRM);
                DealService service = DealService.getInstance();
                service.update(deal);
            }
            req.getSession(false).removeAttribute("deal");
            if (index == 0) {
                Servlets.refreshDistributor(req);
                req.getRequestDispatcher("/workWithAdvertisers.jsp").forward(req, resp);
            }
            else if (index == 1) {
                Servlets.refreshAdvertiser(req);
                req.getRequestDispatcher("/dealToDistributors.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.getRequestDispatcher("/main.jsp").forward(req, resp);
        }
    }
}
