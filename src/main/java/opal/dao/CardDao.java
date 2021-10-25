
package opal.dao;

import opal.entity.Card;
import opal.untils.ConnectionUtil;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardDao {

    Connection conn;

    public void insert(Card card) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into opalcards(ID, CARDNUM, BALANCE) values(?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, card.getId());
            ps.setString(2, card.getCardNum());
            ps.setDouble(3, card.getBalance());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
    }

    public Card queryById(Integer id) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "select * from opalcards where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                Card card = new Card();
                card.setId(set.getInt("id"));
                card.setCardNum(set.getString("CARDNUM"));
                card.setBalance(set.getDouble("BALANCE"));
                return card;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
        return null;
    }

    public Card queryByNumber(String number) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "select * from opalcards where CARDNUM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                Card card = new Card();
                card.setId(set.getInt("id"));
                card.setCardNum(set.getString("CARDNUM"));
                card.setBalance(set.getDouble("BALANCE"));
                return card;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
        return null;
    }

    public List<Card> getAllCards() {
        List<Card> list = new ArrayList<>();
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "select * from opalcards";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Card card = new Card();
                card.setId(set.getInt("id"));
                card.setCardNum(set.getString("CARDNUM"));
                card.setBalance(set.getDouble("BALANCE"));
                list.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
        return list;
    }

    public void updateBalanceById(String cardNum, double balance) {
        Connection conn = ConnectionUtil.getConnection();
        try {
            String sql = "update opalcards set BALANCE = BALANCE+? where CARDNUM=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, balance);
            ps.setString(2, cardNum);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConnection(conn);
        }
    }

}
