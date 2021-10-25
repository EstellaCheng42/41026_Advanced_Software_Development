package opal.card.controller;


import opal.entity.Card;
import opal.dao.CardDao;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/card")
public class CardServlet extends HttpServlet {

        private CardDao cardDao = new CardDao();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        
        
        String method = req.getParameter("method");
        switch (method){
            case "list":
                list(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case"search":
                search(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        //cardService.deleteCard(id);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNum = req.getParameter("cardNum");
        List<Card> list = cardDao.getAllCards();       
        req.setAttribute("cards",list);
        req.getRequestDispatcher("card.jsp").forward(req,resp);
    }
    
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String cardNum = req.getParameter("cardNum");
        List<Card> list = new ArrayList<>();
        if(cardDao.queryByNumber(cardNum) != null){
            Card card = cardDao.queryByNumber(cardNum);
            list.add(card);
        }
        req.setAttribute("cards", list);
        req.getRequestDispatcher("card.jsp").forward(req,resp);
    }
}
