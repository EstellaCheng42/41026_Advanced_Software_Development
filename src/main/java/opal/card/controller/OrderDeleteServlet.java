
package opal.card.controller;


import opal.dao.OrdersDao;
import opal.entity.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sunyuanwei
 */
@WebServlet("/orderDelete")
public class OrderDeleteServlet extends HttpServlet {

    OrdersDao ordersDao = new OrdersDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("orderId"));
        System.out.println(id + "=================");
        ordersDao.delete(id);
        List<Orders> ordersList = ordersDao.getAllOrders();
        req.setAttribute("ordersList", ordersList);
        String path = "order.jsp";
        req.getRequestDispatcher(path).forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    }

}
