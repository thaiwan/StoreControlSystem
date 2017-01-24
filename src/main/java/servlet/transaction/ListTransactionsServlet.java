package servlet.transaction;

import bean.ProductBean;
import bean.StoreBean;
import bean.TransactionBean;
import entity.Transaction;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/transactions")
public class ListTransactionsServlet extends HttpServlet {
    @EJB
    private TransactionBean transactionBean;
    @EJB
    private ProductBean productBean;
    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Transaction> allTransactions = transactionBean.getAll();
        req.setAttribute("transactions", allTransactions);

        req.getRequestDispatcher("/transactions.jsp").forward(req, resp);

    }
}
