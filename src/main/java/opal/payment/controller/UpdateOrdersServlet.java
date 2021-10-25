/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package opal.payment.controller;

import opal.dao.OrderDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.entity.Order;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
@WebServlet("/updateordersServlet")
public class UpdateOrdersServlet extends HttpServlet {
    
    OrderDao orderDao;
    public UpdateOrdersServlet() throws SQLException {
        this.orderDao = new OrderDao();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("id");
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        String addvalue=request.getParameter("v_addvalue");
        String deliveryaddress=request.getParameter("deliveryaddress");
        String state = request.getParameter("state");
        String code=request.getParameter("code");
        String receivername=request.getParameter("receivername");
        
        Order order = new Order();
        order.setId(Integer.parseInt(id));
        order.setFirstName(firstname);
        order.setLastName(lastname);
        order.setAge(Integer.parseInt(age));
        order.setPhone(phone);
        order.setAddvalue(Integer.parseInt(addvalue));
        order.setDeliveryaddress(deliveryaddress);
        order.setState(state);
        order.setCode(code);
        order.setReceivername(receivername);
        
        try{
            orderDao.updateOrder(order);
        }catch (SQLException ex) {
            Logger.getLogger(UpdateOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/ordersServlet").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
