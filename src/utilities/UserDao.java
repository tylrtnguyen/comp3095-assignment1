package utilities;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ca.gbc.assignment1.User;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: UserDao class provides methods that need to
 * get data from database or write data to database
 */

public class UserDao {
	
	// Validate users when they login
	public boolean validate(User user){
		boolean userStatus = false;
		try {
			// Database initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement using con object
			PreparedStatement preparedStatement = con.prepareStatement("select * "
					+ "from Users where email = ? and password = ? ");
			preparedStatement.setString(1,user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			
			// Test preparedStatement
//			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			userStatus = rs.next();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return userStatus;
	}
	
	
	// Get user role ID
	public int getRoleID(User user) {
		int roleID = 0;
		try {
			// Database Initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement to insert new user into database
			// iR = insertRole
			PreparedStatement iRStatement = con.prepareStatement("select roleID from UserRole"+
						" where userID IN (select id from Users where email='"+user.getEmail()+"');");
			
//			System.out.println(iRStatement);
			ResultSet rs = iRStatement.executeQuery();
			if(rs.next()) {
				roleID = rs.getInt("roleID");
				System.out.println(roleID);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return roleID;
	}
	
	public User getUser(String email) {
		User user = new User();
		if(emailDuplicate(email)) {
			try {
				// Database Initialize
				Connection con = DatabaseAccess.connectDataBase();
				// Create a statement to insert new user into database
				// iR = insertRole
				PreparedStatement iRStatement = con.prepareStatement("select * from Users"+
							" where email='"+email+"';");
				
				System.out.println(iRStatement);
				ResultSet rs = iRStatement.executeQuery();
				if(rs.next()) {
					user.setFirstName(rs.getString("firstname"));
					user.setLastName(rs.getString("lastname"));
					user.setEmail(rs.getString("email"));
					System.out.println(user.getFirstName());
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	// Register User
	public int registerUser(User user) {
		int userRegister  = 0;
		try {
			// Database Initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement to insert new user into database
			PreparedStatement insert = con.prepareStatement("insert into Users"+
			"(firstname ,lastname, email, address, password) values" + "(?,?,?,?,?);");
			insert.setString(1,user.getFirstName());
			insert.setString(2, user.getLastName());
			insert.setString(3,user.getEmail());
			insert.setString(4, user.getAddress());
			insert.setString(5, user.getPassword());
			
			//Test insert statement
//			System.out.println(insert);
			userRegister = insert.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRegister;
	}
	
	public int insertRole(User user) {
		int result = 0;
		try {
			// Database Initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement to insert new user into database
			// iR = insertRole
			PreparedStatement iRStatement = con.prepareStatement("insert into UserRole"+
						"(userID,roleID) values" + "((SELECT id FROM Users WHERE email='" + user.getEmail() + "'),2);");
			
			result = iRStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// Check if email is duplicated
	public boolean emailDuplicate(String email) {
		boolean duplicate = false;
		try {
			// Database Initialize
			Connection con = DatabaseAccess.connectDataBase();
			// Create a statement to insert new user into database
			// iR = insertRole
			PreparedStatement iRStatement = con.prepareStatement("select * from Users where email='"+email+"';");
			
			ResultSet rs = iRStatement.executeQuery();
			duplicate = rs.next();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return duplicate;
	}
	
	
}
