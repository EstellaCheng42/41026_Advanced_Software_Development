/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.dao;

import opal.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bababab
 */
public class UserDao {

    private Connection conn;

    public UserDao() throws SQLException {
        DBConnector c;
        try {
            c = new DBConnector();
            conn = c.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Find user by email and password in the database   
    public User findUser(String email, String password) throws SQLException {
        PreparedStatement p = conn.prepareStatement("select * from users where email=? and password=?");
        p.setString(1, email);
        p.setString(2, password);
        ResultSet result = p.executeQuery();
        if (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setFirstName(result.getString("firstName"));
            user.setLastName(result.getString("lastName"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setType(result.getString("type"));
            return user;
        }
        return null;
    }

//Add a user-data into the database   
    public void addUser(User user) throws SQLException {
        PreparedStatement p = conn.prepareStatement("insert into USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, TYPE) values(?, ?, ?, ?, ?)");
        p.setString(1, user.getFirstName());
        p.setString(2, user.getLastName());
        p.setString(3, user.getEmail());
        p.setString(4, user.getPassword());
        p.setString(5, user.getType());
        p.executeUpdate();
    }

//update a user details in the database   
    public void updateUser(User user) throws SQLException {
        PreparedStatement p = conn.prepareStatement("update USERS set FIRSTNAME = ?, LASTNAME=?, EMAIL=?, PASSWORD=?, TYPE=? where id = ?");
        p.setString(1, user.getFirstName());
        p.setString(2, user.getLastName());
        p.setString(3, user.getEmail());
        p.setString(4, user.getPassword());
        p.setString(5, user.getType());
        p.setInt(6, user.getId());
        p.executeUpdate();
    }

    //delete a user from the database   
    public void deleteUser(User user) throws SQLException {
        PreparedStatement p = conn.prepareStatement("delete from USERS where id = ?");
        p.setInt(1, user.getId());
        p.executeUpdate();
    }
    
    public User SearchbyId(int id) throws SQLException {
        User user = null;

        ResultSet rs = null;

        PreparedStatement ps = null;
        try {
            String sql = "select * from users where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return user;
    }
}
