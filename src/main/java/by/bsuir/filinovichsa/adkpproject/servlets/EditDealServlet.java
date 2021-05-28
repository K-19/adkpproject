package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.products.Deal;
import by.bsuir.filinovichsa.adkpproject.services.DealService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editDeal")
public class EditDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dealId = Integer.parseInt(req.getParameter("dealId"));
        DealService service = DealService.getInstance();
        Deal deal = service.findById(dealId);
        req.getSession(false).setAttribute("deal", deal);
        req.getRequestDispatcher("/editDeal.jsp").forward(req, resp);
    }
}
