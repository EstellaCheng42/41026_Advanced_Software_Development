
package opal.untils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static String uername = "opalcardadmin@myopalcardserver"; //db root user
	private static String password = "0000opalcard!";//db root password
	private static String driver = "com.mysql.jdbc.Driver";//jdbc client driver - built in with NetBeans
	private static String url = "jdbc:mysql://myopalcardserver.mysql.database.azure.com:3306/opal?useSSL=false&requireSSL=false";


	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url,uername,password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}


