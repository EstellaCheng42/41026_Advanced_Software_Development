/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package opal.payment.controller;

import opal.dao.OrderDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.entity.Order;

/**
 *
 * @author Administrator
 */
@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {
    OrderDao orderDao;
    public PaymentServlet() throws SQLException {
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
        String cardnumber=request.getParameter("cardnumber");
        String cvv=request.getParameter("cvv");
        String ownername=request.getParameter("ownername");
        
        Order order = new Order();
        order.setId(Integer.parseInt(id));
        order.setCardnumber(cardnumber);
        order.setCvv(cvv);
        order.setOwnername(ownername);
        try{
            orderDao.payOrder(order);
        }catch (SQLException ex) {
            Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
request.getRequestDispatcher("shopping.jsp").forward(request, response);
        //request.getRequestDispatcher("/ordersServlet").forward(request, response);
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
