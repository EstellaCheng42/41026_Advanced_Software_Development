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
@WebServlet(name = "cardManageServlet", value = "/cardManageServlet")
public class cardManageServlet extends HttpServlet {
    OpalCard opalcard;

    CardManagementDao cardManagementDao;

    public cardManageServlet() throws ClassNotFoundException, SQLException{
        cardManagementDao = new CardManagementDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
            ArrayList<OpalCard> cardList = cardManagementDao.getAllCards();
            request.setAttribute("cardList", cardList);
        } catch (SQLException ex) {
            Logger.getLogger(cardManageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("cardManage.jsp").forward(request, response);
    }

}
