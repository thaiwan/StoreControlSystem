package servlet.product;

import bean.ProductBean;
import entity.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ListProductsServlet extends HttpServlet {

    @EJB
    private ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> allProducts = productBean.getAll();

        req.setAttribute("products", allProducts);

        req.getRequestDispatcher("/products.jsp").forward(req, resp);

    }

}
