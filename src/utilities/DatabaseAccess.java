package utilities;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: DatabaseAccess class uses JDBC driver to
 *  create a connection to a MySQL database
 * created by the database.sql script
 */
public class DatabaseAccess {
	private static String username = "admin";;
	private static String password = "password";
	private static String database = "COMP3095";

	private static Connection connect = null;
		  
	public static Connection connectDataBase() throws Exception {
		 try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?"+ "user="+username+"&password="+password+"&serverTimezone=UTC");
		      return connect;
		    } catch (Exception e) {
		      throw e;
		    } 
		  }
}
