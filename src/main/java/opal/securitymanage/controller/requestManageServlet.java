/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.securitymanage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.dao.CardManagementDao;
import opal.dao.SecurityRequestDao;
import opal.entity.SecurityRequest;

/**
 *
 * @author chengming
 */
@WebServlet(name = "requestManageServlet", value = "/requestManageServlet")
public class requestManageServlet extends HttpServlet {
    SecurityRequest request;
    SecurityRequestDao securityRequestDao;
          
     public requestManageServlet() throws ClassNotFoundException, SQLException{
        securityRequestDao = new SecurityRequestDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            List<SecurityRequest> requestList = securityRequestDao.GetAllRequests();
            request.setAttribute("requestList", requestList);
        } catch (SQLException ex) {
            Logger.getLogger(requestManageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("securityRequestList.jsp").forward(request, response);
    }

}
