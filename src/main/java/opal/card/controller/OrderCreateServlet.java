
package opal.card.controller;


import opal.dao.CardDao;
import opal.entity.Orders;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.dao.OrdersDao;

/**
 *
 * @author sunyuanwei
 */
@WebServlet("/orderCreate")
public class OrderCreateServlet extends HttpServlet {

    OrdersDao orderDao = new OrdersDao();
    CardDao cardDao = new CardDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Orders order = new Orders();
        String cardNum = request.getParameter("opalCardNum");
        double balance = Double.parseDouble(request.getParameter("amount"));
        order.setCreditCardId(Integer.parseInt(request.getParameter("creditCardNum")));
        order.setOpalCardId(Integer.parseInt(request.getParameter("opalCardNum")));
        order.setAmount(Double.parseDouble(request.getParameter("amount")));
        order.setCustomerId(Integer.parseInt(request.getParameter("customer_id")));
        orderDao.insert(order);
        cardDao.updateBalanceById(cardNum,balance);
        response.sendRedirect("orders?method=list");
    }
}
