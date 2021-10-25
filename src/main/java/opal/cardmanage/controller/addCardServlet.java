/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.cardmanage.controller;

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
import opal.dao.CardManagementDao;
import opal.entity.OpalCard;

/**
 *
 * @author chengming
 */
@WebServlet(name = "addCardServlet", value = "/addCardServlet")
public class addCardServlet extends HttpServlet {
    CardManagementDao cardManagementDao;
    
     public addCardServlet() throws ClassNotFoundException, SQLException{
        cardManagementDao = new CardManagementDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cardNo= request.getParameter("cardno");
        String securityCode = request.getParameter("code");
        String nickname = request.getParameter("nickname");
        String cardType = request.getParameter("type");
        OpalCard newcard = new OpalCard();
     
        newcard.setCardNo(cardNo);
        newcard.setsecurityCode(securityCode);
        newcard.setnickname(nickname);
        newcard.setcardType(cardType);
        cardManagementDao.AddCard(newcard);
        response.sendRedirect("cardManageServlet");
    }

}
