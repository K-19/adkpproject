package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.ad.AdType;
import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("addProduct", true);
        req.getRequestDispatcher("myProducts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameProduct = Servlets.getStringParameter(req, "nameProduct");
        String descriptionProduct = Servlets.getStringParameter(req, "descriptionProduct");
        String adCode = Servlets.getStringParameter(req, "adCode");
        AdType adType = null;
        for (AdType type : AdType.values()) {
            if (type.getName().equals(adCode)) {
                adType = type;
                break;
            }
        }
        try {
            Advertiser user = (Advertiser) req.getSession(false).getAttribute("user");
            if (user != null) {
                Product newProduct = new Product(nameProduct, descriptionProduct, adType, user);
                user.addProduct(newProduct);
                UserService service = UserService.getInstance();
                service.updateAdvertiser(user);
                req.getServletContext().getRequestDispatcher("/myProducts.jsp").forward(req, resp);
            } else throw new Exception();
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/hello.jsp");
        }
    }
}
