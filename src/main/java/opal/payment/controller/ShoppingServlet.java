package opal.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import opal.entity.Order;

/**
 *
 * @author Administrator
 */
@WebServlet("/shoppingServlet")
public class ShoppingServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //receive parameter
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        String self_add_value= request.getParameter("self_add_value");
        String addvalue=request.getParameter("v_addvalue");
        String deliveryaddress=request.getParameter("deliveryaddress");
        String state = request.getParameter("state");
        String code=request.getParameter("code");
        String receivername=request.getParameter("receivername");
        String cardtype=request.getParameter("cardtype");
        if(!self_add_value.equals("")){
            addvalue=self_add_value;
        }
        
        //send value to page
        Order order = new Order();
        order.setCardtype(cardtype);
        order.setFirstName(firstname);
        order.setLastName(lastname);
        order.setAge(Integer.parseInt(age));
        order.setPhone(phone);
        order.setAddvalue(Integer.parseInt(addvalue));
        order.setDeliveryaddress(deliveryaddress);
        order.setState(state);
        order.setCode(code);
        order.setReceivername(receivername);
        request.setAttribute("orderinfo", order);
 
        //jump page
        request.getRequestDispatcher("shopthree.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
