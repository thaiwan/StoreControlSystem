package servlet.transaction;

import bean.TransactionBean;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletetransaction")
public class DeleteTransactionServlet extends HttpServlet {

    @EJB
    private TransactionBean transactionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(StringUtils.isNotEmpty(req.getParameter("id"))){
            int id = Integer.valueOf(req.getParameter("id"));
            transactionBean.delete(id);
        }
        resp.sendRedirect("transactions");
    }
}
