/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.securitymanage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.dao.SecurityRequestDao;
import opal.entity.SecurityRequest;

/**
 *
 * @author chengming
 */
@WebServlet(name = "requestDetailServlet", value  = "/requestDetailServlet")
public class requestDetailServlet extends HttpServlet {
     SecurityRequest request;
    SecurityRequestDao securityRequestDao;
          
     public requestDetailServlet() throws ClassNotFoundException, SQLException{
        securityRequestDao = new SecurityRequestDao();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int requestId = Integer.parseInt(request.getParameter("requestId"));
         SecurityRequest securityRequest=null;
         try {
             securityRequest = securityRequestDao.SearchbyId(requestId);
         } catch (SQLException ex) {
             Logger.getLogger(requestDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
        request.setAttribute("securityRequest",securityRequest);
        request.getRequestDispatcher("requestDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

}
