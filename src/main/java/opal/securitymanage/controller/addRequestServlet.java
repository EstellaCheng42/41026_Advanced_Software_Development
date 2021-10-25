/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.securitymanage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "addRequestServlet", urlPatterns = "/addRequestServlet")
public class addRequestServlet extends HttpServlet {
    SecurityRequest request;
    SecurityRequestDao securityRequestDao;
          
     public addRequestServlet() throws ClassNotFoundException, SQLException{
        securityRequestDao = new SecurityRequestDao();
    }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addSecurityRequest.jsp").forward(request, response);

    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardNo = request.getParameter("cardno");
        SecurityRequest newrequest = new SecurityRequest();
        newrequest.setCardNo(cardNo);
        securityRequestDao.AddRequest(newrequest);
        response.sendRedirect("requestManageServlet");
    }
}
