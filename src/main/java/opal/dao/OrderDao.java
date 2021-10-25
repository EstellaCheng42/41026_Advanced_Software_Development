/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import opal.entity.Order;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class OrderDao {
    private Connection conn;
    
    public OrderDao() throws SQLException {
        DBConnector c;
        try {
            c = new DBConnector();
            conn = c.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Add a order-data into the database
    public void addOrder(Order order) throws SQLException {
        PreparedStatement p = conn.prepareStatement("insert into ORDERS (CARDTYPE,FIRSTNAME, LASTNAME,AGE,PHONE,ADDVALUE,DELIVERYADDRESS,STATE,CODE,RECEIVERNAME,UID,STATUS) values (?,?,?,?,?,?,?,?,?,?,?,?)");
        p.setString(1, order.getCardtype());
        p.setString(2, order.getFirstName());
        p.setString(3, order.getLastName());
        p.setInt(4, order.getAge());
        p.setString(5, order.getPhone());
        p.setInt(6, order.getAddvalue());
        p.setString(7, order.getDeliveryaddress());
        p.setString(8, order.getState());
        p.setString(9, order.getCode());
        p.setString(10, order.getReceivername());
        p.setInt(11,order.getUid());
        p.setInt(12,0);
        p.executeUpdate();
    }
    
    public List<Order> getMyOrders(int uid) throws SQLException {
        List<Order> list = new ArrayList();
        PreparedStatement p = conn.prepareStatement("select * from ORDERS where UID=?");
        p.setInt(1,uid);
        ResultSet result = p.executeQuery();
        while(result.next()){
            Order order = new Order();
            order.setId(result.getInt("ID"));
            order.setCardtype(result.getString("CARDTYPE"));
            order.setFirstName(result.getString("FIRSTNAME"));
            order.setLastName(result.getString("LASTNAME"));
            order.setAge(result.getInt("AGE"));
            order.setPhone(result.getString("PHONE"));
            order.setAddvalue(result.getInt("ADDVALUE"));
            order.setDeliveryaddress(result.getString("DELIVERYADDRESS"));
            order.setState(result.getString("STATE"));
            order.setCode(result.getString("CODE"));
            order.setReceivername(result.getString("RECEIVERNAME"));
            order.setStatus(result.getInt("STATUS"));
            list.add(order);
        }
        return list;
    }
    
    //delete a order from the database
    public void deleteOrder(int id) throws SQLException {
        PreparedStatement p = conn.prepareStatement("delete from ORDERS where ID = ?");
        p.setInt(1, id);
        p.executeUpdate();
    }
    
    //Find order by id in the database
    public Order findOrder(int id) throws SQLException {
        PreparedStatement p = conn.prepareStatement("select * from ORDERS where ID=?");
        p.setInt(1,id);
        ResultSet result = p.executeQuery();
        if (result.next()) {
            Order order = new Order();
            order.setId(result.getInt("ID"));
            order.setCardtype(result.getString("CARDTYPE"));
            order.setFirstName(result.getString("FIRSTNAME"));
            order.setLastName(result.getString("LASTNAME"));
            order.setAge(result.getInt("AGE"));
            order.setPhone(result.getString("PHONE"));
            order.setAddvalue(result.getInt("ADDVALUE"));
            order.setDeliveryaddress(result.getString("DELIVERYADDRESS"));
            order.setState(result.getString("STATE"));
            order.setCode(result.getString("CODE"));
            order.setReceivername(result.getString("RECEIVERNAME"));
            return order;
        }
        return null;
    }
    
    //Update a order details in the database   
    public void updateOrder(Order order) throws SQLException {
        PreparedStatement p = conn.prepareStatement("update ORDERS set FIRSTNAME = ?, LASTNAME=?,AGE=?,PHONE=?,ADDVALUE=?,DELIVERYADDRESS=?,STATE=?,CODE=?,RECEIVERNAME=? where ID = ?");
        p.setString(1, order.getFirstName());
        p.setString(2, order.getLastName());
        p.setInt(3, order.getAge());
        p.setString(4, order.getPhone());
        p.setInt(5, order.getAddvalue());
        p.setString(6, order.getDeliveryaddress());
        p.setString(7, order.getState());
        p.setString(8, order.getCode());
        p.setString(9, order.getReceivername());
        p.setInt(10,order.getId());
        p.executeUpdate();
    }
    
    //pay a order in the database
    public void payOrder(Order order) throws SQLException {
        PreparedStatement p = conn.prepareStatement("update ORDERS set CARDNUMBER=?,CVV=?,OWNERNAME=?,STATUS=? where ID=?");
        p.setString(1,order.getCardnumber());
        p.setString(2,order.getCvv());
        p.setString(3,order.getOwnername());
        p.setInt(4,1);
        p.setInt(5,order.getId());
        p.executeUpdate();
    }
    
    public List<Order> getMyPayOrders(int uid) throws SQLException {
        List<Order> list = new ArrayList();
        PreparedStatement p = conn.prepareStatement("select * from ORDERS where UID=? and STATUS=1");
        p.setInt(1,uid);
        ResultSet result = p.executeQuery();
        while(result.next()){
            Order order = new Order();
            order.setId(result.getInt("ID"));
            order.setCardtype(result.getString("CARDTYPE"));
            order.setFirstName(result.getString("FIRSTNAME"));
            order.setLastName(result.getString("LASTNAME"));
            order.setAge(result.getInt("AGE"));
            order.setPhone(result.getString("PHONE"));
            order.setAddvalue(result.getInt("ADDVALUE"));
            order.setDeliveryaddress(result.getString("DELIVERYADDRESS"));
            order.setState(result.getString("STATE"));
            order.setCode(result.getString("CODE"));
            order.setReceivername(result.getString("RECEIVERNAME"));
            order.setStatus(result.getInt("STATUS"));
            list.add(order);
        }
        return list;
    }
}
