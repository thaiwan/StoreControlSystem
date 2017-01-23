package servlet.transaction;

import bean.ProductBean;
import bean.StoreBean;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/addtransaction")
public class AddAndEditTransactionServlet extends HttpServlet {

    @EJB
    private TransactionBean transactionBean;
    @EJB
    private StoreBean storeBean;
    @EJB
    private ProductBean productBean;

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
        req.setAttribute("stores", storeBean.getAll());
        req.setAttribute("products", productBean.getAll());
        req.getRequestDispatcher("/addedittransaction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            req.setCharacterEncoding("UTF-8");


            Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").
                    parse(req.getParameter("transactionDate")).getTime());
            int storeId = Integer.valueOf(req.getParameter("storeId"));
            int count = Integer.valueOf(req.getParameter("count"));
            int productId = Integer.valueOf(req.getParameter("productId"));
            int cost = Integer.valueOf(req.getParameter("cost"));

            if(StringUtils.isNotEmpty(req.getParameter("id"))) {
                int id = Integer.valueOf(req.getParameter("id"));
                Transaction transaction = transactionBean.get(id);
                transaction.setStoreId(storeId);
                transaction.setTransactionDate(date);
                transaction.setCount(count);
                transaction.setCost(cost);
                transaction.setProductId(productId);
                transactionBean.update(transaction);
            } else{
                transactionBean.add(new Transaction(
                        storeId,
                        date,
                        count,
                        cost,
                        productId));
            }

            resp.sendRedirect("transactions");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
