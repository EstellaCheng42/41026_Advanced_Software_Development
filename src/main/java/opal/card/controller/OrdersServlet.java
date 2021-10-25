
package opal.card.controller;


import opal.entity.Orders;
import opal.entity.User;
import opal.dao.OrdersDao;
import opal.untils.Result;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

    private OrdersDao ordersDao = new OrdersDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String method = req.getParameter("method");
        switch (method){
            case "list":
                list(req,resp);
                break;
            case"search":
                search(req,resp);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User sysUser = (User)(req.getSession().getAttribute("loginUser"));

        List<Orders> ordersList = ordersDao.getAllOrders();
        req.setAttribute("ordersList",ordersList);
        String path = "order.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }
    
        private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int orderId = Integer.valueOf(req.getParameter("orderId"));
        List<Orders> list = new ArrayList<>();
        if(ordersDao.queryById(orderId) != null){
            Orders order = ordersDao.queryById(orderId);
            list.add(order);
        }
        req.setAttribute("ordersList", list);
        req.getRequestDispatcher("order.jsp").forward(req,resp);
    }

}
