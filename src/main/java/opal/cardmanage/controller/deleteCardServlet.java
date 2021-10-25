/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.cardmanage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.dao.CardManagementDao;
import opal.entity.OpalCard;

/**
 *
 * @author chengming
 */
@WebServlet(name = "deleteCardServlet", value = "/deleteCardServlet")
public class deleteCardServlet extends HttpServlet {
     OpalCard opalcard;
     
     CardManagementDao cardManagementDao;

    public deleteCardServlet() throws ClassNotFoundException, SQLException{
        cardManagementDao = new CardManagementDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cardManagementDao.DeleteCard(request.getParameter("cardId"));
        response.sendRedirect("cardManageServlet");
    }

}
