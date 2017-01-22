package servlet;

import bean.StoreBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteStoreServlet extends HttpServlet {

    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(req.getParameter("id") != null && req.getParameter("id") != ""){
            long id = Long.valueOf(req.getParameter("id"));
            storeBean.delete(id);
        }
        resp.sendRedirect("list");
    }
}