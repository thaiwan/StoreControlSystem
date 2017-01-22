package servlet.store;

import bean.StoreBean;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletestore")
public class DeleteStoreServlet extends HttpServlet {

    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(StringUtils.isNotEmpty(req.getParameter("id"))){
            int id = Integer.valueOf(req.getParameter("id"));
            storeBean.delete(id);
        }
        resp.sendRedirect("stores");
    }
}