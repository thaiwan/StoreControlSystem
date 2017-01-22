package servlet.product;


import bean.ProductBean;
import entity.Product;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addproduct")
public class AddAndEditProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null){
            int id = Integer.valueOf(req.getParameter("edit"));
            Product product = productBean.get(id);
            req.setAttribute("product", product);
        }

        req.getRequestDispatcher("/addeditproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");

        if(StringUtils.isNotEmpty(req.getParameter("id"))) {
            int id = Integer.valueOf(req.getParameter("id"));
            Product product = productBean.get(id);
            product.setName(name);
            productBean.update(product);
        } else{
            productBean.add(new Product(name));
        }

        resp.sendRedirect("products");
    }
}
