/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import opal.entity.OpalCard;

/**
 *
 * @author chengming
 */
public class CardManagementDao {

    private Connection conn;

    public CardManagementDao() throws ClassNotFoundException, SQLException {
        conn = (new DBConnector()).getConnection();
    }

    public void AddCard(OpalCard opalCard) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into opalcard (cardNo,securityCode,nickname,cardType) values(?, ?, ?, ?)");
            ps.setString(1, opalCard.getCardNo());
            ps.setString(2, opalCard.getsecurityCode());
            ps.setString(3, opalCard.getnickname());
            ps.setString(4, opalCard.getcardType());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateCard(OpalCard opalcard) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update opalcard set cardNo=?, securityCode=?, nickname=?, cardType=? where cardId=?");
        ps.setString(1, opalcard.getCardNo());
        ps.setString(2, opalcard.getsecurityCode());
        ps.setString(3, opalcard.getnickname());
        ps.setString(4, opalcard.getcardType());
        ps.setInt(5,opalcard.getCardId());
        ps.executeUpdate();  
    }

    public void DeleteCard(String cardId) {
        String sql = "delete from opalcard where CARDID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, cardId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OpalCard SearchbyId(int cardId) throws SQLException {
        OpalCard opalcard = null;

        ResultSet rs = null;

        PreparedStatement ps = null;
        try {
            String sql = "select * from opalcard where cardId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cardId);
            rs = ps.executeQuery();

            while (rs.next()) {
                opalcard = new OpalCard(
                        rs.getInt("cardId"),
                        rs.getString("cardno"),
                        rs.getString("securityCode"),
                        rs.getString("nickname"),
                        rs.getString("cardType")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return opalcard;
    }

    public ArrayList<OpalCard> ListCardbyId(int userId) throws SQLException {
        ArrayList<OpalCard> cardList = new ArrayList<OpalCard>();

        PreparedStatement ps = null;
        try {
            String sql = "select * from opalcard where USERID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cardList.add(new OpalCard(
                        rs.getInt("cardId"),
                        rs.getString("cardNo"),
                        rs.getString("securityCode"),
                        rs.getString("nickname"),
                        rs.getString("cardType")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return cardList;
    }
    
     public ArrayList<OpalCard> getAllCards()throws SQLException{
         ArrayList<OpalCard> cardList = new ArrayList<OpalCard>();
         String sql = "select * from opalcard";
         PreparedStatement ps = null;
          ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
         while (rs.next()) {
                cardList.add(new OpalCard(
                        rs.getInt("cardId"),
                        rs.getString("cardNo"),
                        rs.getString("securityCode"),
                        rs.getString("nickname"),
                        rs.getString("cardType")
                ));
            }
         return cardList;
    }

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CardManagementDao dao = new CardManagementDao();
        dao.ListCardbyId(1000);     
    }
}
