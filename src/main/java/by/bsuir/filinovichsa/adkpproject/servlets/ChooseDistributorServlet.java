package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.ProductService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.AbstractUser;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chooseDistributor")
public class ChooseDistributorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int idProduct = Integer.parseInt(Servlets.getStringParameter(req, "product"));
            ProductService service = ProductService.getInstance();
            Product product = service.findById(idProduct);
            if (product == null) {
                req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
                return;
            }
            Advertiser user = (Advertiser) req.getSession(false).getAttribute("user");
            if (!user.hasProductWithId(idProduct)) {
                req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
                return;
            }
            req.getSession(false).setAttribute("product", product);
            UserService userService = UserService.getInstance();
            List<Distributor> distributorList = userService.findAllDistributors();
            List<Distributor> availableDistributors = new ArrayList<>();
            for (Distributor distributor : distributorList) {
                if (distributor.getDistributorType().checkAvailableType(product.getAdType()))
                    availableDistributors.add(distributor);
            }
            req.setAttribute("distributors", availableDistributors);
            req.getRequestDispatcher("/chooseDistributor.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
        }
    }
}
