package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AbstractAd;
import by.bsuir.filinovichsa.adkpproject.factories.AdFactory;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signUpProduct")
public class SignUpProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            Advertiser advertiser = (Advertiser) session.getAttribute("user");
            Product product = (Product) session.getAttribute("newProduct");

            Object[] parameters = Servlets.readAdByRequest(req, product.getAdType());
            AdFactory factory = new AdFactory();
            advertiser.addProduct(product);
            UserService service = UserService.getInstance();
            service.updateAdvertiser(advertiser);

            req.getSession(false).removeAttribute("newProduct");
            req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);

        } catch (Exception e) {
            req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
        }
    }
}
