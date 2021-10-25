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
import java.util.List;
import opal.entity.OpalCard;
import opal.entity.SecurityRequest;

/**
 *
 * @author chengming
 */
public class SecurityRequestDao {
     private Connection conn;

    public SecurityRequestDao() throws ClassNotFoundException, SQLException {
        conn = (new DBConnector()).getConnection();
    }
     public void AddRequest(SecurityRequest request) { 
        try {
            PreparedStatement ps = conn.prepareStatement("insert into requests (cardNo) values(?)");
            ps.setString(1, request.getCardNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
     public ArrayList<SecurityRequest> GetAllRequests() throws SQLException {
        ArrayList<SecurityRequest> requestList = new ArrayList<SecurityRequest>();

        PreparedStatement ps = null;
        try {
            String sql = "select * from requests";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                requestList.add(new SecurityRequest(
                        rs.getInt("requestId"),
                        rs.getString("cardNo"),
                        rs.getString("requestDate"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return requestList;
    }
     
       public SecurityRequest SearchbyId(int requestId) throws SQLException {
        SecurityRequest request = null;

        ResultSet rs = null;

        PreparedStatement ps = null;
        try {
            String sql = "select * from requests where requestId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, requestId);
            rs = ps.executeQuery();

            while (rs.next()) {
                request = new SecurityRequest(
                        rs.getInt("requestId"),
                        rs.getString("cardno"),
                        rs.getString("requestDate"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return request;
    }
     
      public void DeleteRequest(String requestId) {
        String sql = "delete from requests where REQUESTID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public void UpdateRequest(int requestId) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("update requests set status='Confirmed' where requestId=?");
        ps.setInt(1, requestId);
        ps.executeUpdate();
      }

      public void main(String[] args) throws ClassNotFoundException, SQLException{
          SecurityRequestDao dao= new SecurityRequestDao();
      }
}
