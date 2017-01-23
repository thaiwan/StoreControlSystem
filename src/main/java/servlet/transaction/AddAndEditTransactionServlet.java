package servlet.transaction;

import bean.TransactionBean;
import entity.Transaction;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/addtransaction")
public class AddAndEditTransactionServlet extends HttpServlet {

    @EJB
    private TransactionBean transactionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("edit") != null){
            int id = Integer.valueOf(req.getParameter("edit"));
            Transaction transaction = transactionBean.get(id);
            req.setAttribute("transaction", transaction);
        }

        req.getRequestDispatcher("/addedittransaction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");

        String store = req.getParameter("store");
        String transactionDate = req.getParameter("transactionDate");
        String count = req.getParameter("count");
        String cost = req.getParameter("cost");
        String productId = req.getParameter("product_id");

        if(StringUtils.isNotEmpty(req.getParameter("id"))) {
            int id = Integer.valueOf(req.getParameter("id"));
            Transaction transaction = transactionBean.get(id);
            transaction.setStoreId(Integer.valueOf(store));
            transaction.setTransactionDate(Date.valueOf(transactionDate));
            transaction.setCount(Integer.valueOf(count));
            transaction.setCost(Integer.valueOf(cost));
            transaction.setProductId(Integer.valueOf(productId));
            transactionBean.update(transaction);
        } else{
            transactionBean.add(new Transaction(
                    Integer.valueOf(store),
                    Date.valueOf(transactionDate),
                    Integer.valueOf(count),
                    Integer.valueOf(cost),
                    Integer.valueOf(productId)));
        }

        resp.sendRedirect("transactions");
    }
}
