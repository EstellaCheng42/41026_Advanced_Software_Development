/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.cardmanage.controller;

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
import opal.entity.OpalCard;

/**
 *
 * @author chengming
 */
@WebServlet(name = "cardDetailServlet", value = "/cardDetailServlet")
public class cardDetailServlet extends HttpServlet {
    CardManagementDao cardManagementDao;

    public cardDetailServlet() throws ClassNotFoundException, SQLException{
        cardManagementDao = new CardManagementDao();
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cardID = Integer.parseInt(request.getParameter("cardId"));
        try {
            OpalCard opalcard = cardManagementDao.SearchbyId(cardID);
            request.setAttribute("opalcard",opalcard);
        } catch (SQLException ex) {
            Logger.getLogger(cardDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("cardDetails.jsp").forward(request, response);
    }
}
