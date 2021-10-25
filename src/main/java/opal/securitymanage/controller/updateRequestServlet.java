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
@WebServlet(name = "updateRequestServlet", value = "/updateRequestServlet")
public class updateRequestServlet extends HttpServlet {

    SecurityRequest request;
    SecurityRequestDao securityRequestDao;

    public updateRequestServlet() throws ClassNotFoundException, SQLException {
        securityRequestDao = new SecurityRequestDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
            try {
                securityRequestDao.UpdateRequest(Integer.parseInt(request.getParameter("requestId")));
            } catch (SQLException ex) {
                Logger.getLogger(updateRequestServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("requestDetailServlet?requestId="+request.getParameter("requestId"));
       
    }
}
