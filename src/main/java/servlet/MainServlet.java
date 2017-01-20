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

@WebServlet("/list")
public class MainServlet extends HttpServlet{

    // Аннотация говорит о том,
    // что данный объект будет инициализирован
    // контейнером Glassfish DI
    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Получаем список пользователей
        List<Store> allStores = storeBean.getAll();

        // добавляем полученный список в request,
        // который отправится на jsp
        req.setAttribute("stores", allStores);

        // отправляем request на jsp
        req.getRequestDispatcher("/list.jsp").forward(req, resp);

    }

}
