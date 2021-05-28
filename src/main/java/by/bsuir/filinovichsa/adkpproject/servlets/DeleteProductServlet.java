package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.ProductService;
import by.bsuir.filinovichsa.adkpproject.users.Advertiser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProd = Integer.parseInt(req.getParameter("dealId"));

        ProductService service = ProductService.getInstance();
        Product product = service.findById(idProd);
        service.delete(product);
        Advertiser advertiser = (Advertiser) req.getSession(false).getAttribute("user");
        advertiser.getProducts().remove(product);

        Servlets.refreshAdvertiser(req);
        req.getRequestDispatcher("/myProducts.jsp").forward(req, resp);
    }
}
