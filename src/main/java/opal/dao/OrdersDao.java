
package opal.dao;


import opal.entity.Card;
import opal.entity.Orders;
import opal.untils.ConnectionUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {

    public void insert(Orders order) {

        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into cardOrder(cardId, creditCardId, amount, customerId) values(?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, order.getOpalCardId());
            ps.setInt(2, order.getCreditCardId());
            ps.setDouble(3, order.getAmount());
            ps.setInt(4, order.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }

    }

    public void delete(Integer id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "delete from cardOrder where ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(id + "=======================");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
    }

    public Orders queryById(Integer id) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "select * from cardOrder where ID = " + id;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                Orders obj = new Orders();
                obj.setId(set.getInt("ID"));
                obj.setOpalCardId(set.getInt("cardId"));
                obj.setAmount(set.getDouble("amount"));
                obj.setCustomerId(set.getInt("customerId"));
                obj.setCreditCardId(set.getInt("creditCardId"));
                return obj;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
        return null;
    }

    public List<Orders> getAllOrders() {
        List<Orders> list = new ArrayList<>();
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "select * from cardOrder";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Orders order = new Orders();
                order.setId(set.getInt("ID"));
                order.setCreditCardId(set.getInt("creditCardId"));
                order.setOpalCardId(set.getInt("cardId"));
                order.setCustomerId(set.getInt("customerId"));
                order.setAmount(set.getDouble("amount"));
                System.out.println(order.toString());
                System.out.println("creditCardId: " + set.getInt("creditCardId"));
                System.out.println("opalCardId: " + set.getInt("cardId"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
        return list;
    }
}

