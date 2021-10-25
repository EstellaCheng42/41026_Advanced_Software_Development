/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB {
    private Connection conn; //connection null-instance to be initialized in sub-classes

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
    
        conn = DriverManager.getConnection(URL, dbuser, dbpass);
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection() throws SQLException {

        this.conn.close();

    }

}
