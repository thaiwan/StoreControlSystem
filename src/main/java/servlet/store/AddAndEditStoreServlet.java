package servlet.store;



import bean.StoreBean;
import entity.Store;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addstore")
public class AddAndEditStoreServlet extends HttpServlet {

    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null){
            int id = Integer.valueOf(req.getParameter("edit"));
            Store store = storeBean.get(id);
            req.setAttribute("store", store);
        }

        req.getRequestDispatcher("/addeditstore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String address = req.getParameter("address");

        if(StringUtils.isNotEmpty(req.getParameter("id"))) {
            int id = Integer.valueOf(req.getParameter("id"));
            Store store = storeBean.get(id);
            store.setAddress(address);
            storeBean.update(store);
        } else{
            storeBean.add(new Store(address));
        }

        resp.sendRedirect("stores");
    }
}