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
@WebServlet(name = "updateCardServlet", value = "/updateCardServlet")
public class updateCardServlet extends HttpServlet {
    OpalCard opalcard;
    CardManagementDao cardManagementDao;

    public updateCardServlet() throws ClassNotFoundException, SQLException{
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
        request.getRequestDispatcher("updateCardDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String cardNo = request.getParameter("cardno");
        String securityCode = request.getParameter("code");
        String nickname = request.getParameter("nickname");
        String cardType = request.getParameter("type");
        String cardId= request.getParameter("cardId");
    
        OpalCard newCard = new OpalCard();
        newCard.setCardNo(cardNo);
        newCard.setsecurityCode(securityCode);
        newCard.setnickname(nickname);
        newCard.setcardType(cardType);
        newCard.setCardId(Integer.parseInt(cardId));
        
        try {
            cardManagementDao.UpdateCard(newCard);
        } catch (SQLException ex) {
            Logger.getLogger(updateCardServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        response.sendRedirect("cardDetailServlet?cardId="+cardId);
        
    }


}
