package opal.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import opal.entity.Order;
import opal.dao.OrderDao;

/**
 *
 * @author Administrator
 */
@WebServlet("/createorderServlet")
public class CreateOrderServlet extends HttpServlet {
    
    OrderDao orderDao;
    public CreateOrderServlet() throws SQLException {
        this.orderDao = new OrderDao();
    }

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
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String age=request.getParameter("age");
        String phone=request.getParameter("phone");
        String addvalue=request.getParameter("addvalue");
        String deliveryaddress=request.getParameter("deliveryaddress");
        String state = request.getParameter("state");
        String code=request.getParameter("code");
        String receivername=request.getParameter("receivername");
        String cardtype=request.getParameter("cardtype");
        
        //save db
        try {
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
            
            //User user = (User) request.getSession().getAttribute("loginUser");
order.setUid(1);
          // order.setUid(user.getId());
            orderDao.addOrder(order);
        }catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("msg", "Create Order Success");
        request.getRequestDispatcher("shopping.jsp").forward(request, response);
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
