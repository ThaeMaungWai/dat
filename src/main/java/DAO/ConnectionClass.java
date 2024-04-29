package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	 public static Connection myConnection() {
	        Connection con = null;
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "root");
	        } catch (ClassNotFoundException e) {
	            System.out.println("Oracle JDBC Driver not found");
	        } catch (SQLException e) {
	            System.out.println("Database Connection failed");
	        }
	        return con;
	    }

	
}
