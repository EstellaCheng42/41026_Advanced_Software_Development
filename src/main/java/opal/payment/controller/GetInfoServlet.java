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
@WebServlet("/getinfoServlet")
public class GetInfoServlet extends HttpServlet {

    OrderDao orderDao;
    public GetInfoServlet() throws SQLException {
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
        String id=request.getParameter("id");
        String op=request.getParameter("op");
        Order order = new Order();
        try{
            order = orderDao.findOrder(Integer.parseInt(id));
            request.setAttribute("orderinfo", order);
        }
        catch (SQLException ex) {
            Logger.getLogger(GetInfoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jumppage="";
        if(op.equals("edit")){
            jumppage="editorders.jsp";
        }else if(op.equals("checkout")){
            jumppage="checkoutorders.jsp";
        }else if(op.equals("pay")){
            jumppage="payorders.jsp";
        }else if(op.equals("history")){
            jumppage="dispay.jsp";
        }
        request.getRequestDispatcher(jumppage).forward(request, response);
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
