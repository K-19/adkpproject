package by.bsuir.filinovichsa.adkpproject.servlets;

import by.bsuir.filinovichsa.adkpproject.products.Product;
import by.bsuir.filinovichsa.adkpproject.services.ProductService;
import by.bsuir.filinovichsa.adkpproject.services.UserService;
import by.bsuir.filinovichsa.adkpproject.users.Distributor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUpDeal")
public class SignUpDealServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDist = Integer.parseInt(Servlets.getStringParameter(req, "dist"));
        UserService userService = UserService.getInstance();
        Distributor distributor = (Distributor) userService.findDistributor(idDist);
        req.getSession(false).setAttribute("distributor", distributor);
        req.getRequestDispatcher("/signUpDeal.jsp").forward(req, resp);
    }
}
