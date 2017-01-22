package servlet;

import bean.StoreBean;
import entity.Store;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stores")
public class MainServlet extends HttpServlet{

    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Store> allStores = storeBean.getAll();

        req.setAttribute("stores", allStores);

        req.getRequestDispatcher("/stores.jsp").forward(req, resp);

    }

}
