
package opal.card.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.entity.Card;
import opal.entity.Orders;
import opal.dao.CardDao;
import opal.dao.OrdersDao;

/**
 *
 * @author sunyuanwei
 */
@WebServlet("/topup")
public class TopupServlet extends HttpServlet {

    CardDao cardDao = new CardDao();
    OrdersDao orderDao = new OrdersDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cardId"));
        Card card = cardDao.queryById(id);
        request.setAttribute("card", card);
        request.getRequestDispatcher("topup.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
