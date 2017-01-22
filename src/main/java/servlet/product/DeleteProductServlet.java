package servlet.product;

import bean.ProductBean;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
    @EJB
    private ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(StringUtils.isNotEmpty(req.getParameter("id"))){
            int id = Integer.valueOf(req.getParameter("id"));
            productBean.delete(id);
        }
        resp.sendRedirect("products");
    }
}
