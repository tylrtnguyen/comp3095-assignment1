package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ca.gbc.assignment1.User;

public class LoginDao {
	public boolean validate(User user){
		boolean userStatus = false;
		try {
			// DataBase initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement using con object
			PreparedStatement preparedStatement = con.prepareStatement("select * "
					+ "from User where username = ? and password = ? ");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			// Test preparedStatement
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			userStatus = rs.next();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return userStatus;
	}
	
}
