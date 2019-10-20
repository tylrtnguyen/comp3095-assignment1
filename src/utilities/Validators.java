package utilities;

import ca.gbc.assignment1.User;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: Validators class provides validators for Login 
 * and Registration forms based on the Validation Requirements
 */
public class Validators {

	public boolean pwValidator(User user) {
		String password = user.getPassword();
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}";
		return password.matches(pattern);
	}
	public boolean pwMatchValidator(String password,String cfPassword) {
		return cfPassword.equals(password);
	}
	public boolean nullValidator(User user) {
		
		boolean validate = false;
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String address = user.getAddress();
		String email = user.getEmail();
		String password = user.getPassword();
		
		if(firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0 &&
				address != null && address.length() > 0 && email != null && email.length() > 0 &&
				password != null && password.length() > 0) {
				validate = true;
		}
		return validate;
	}
	public boolean nameValidator(User user) {
		String fName = user.getFirstName();
		String lName = user.getLastName();
		String pattern = "^[A-Za-z\\s]+$";
		return (fName.matches(pattern) && lName.matches(pattern));
	}

	public boolean emailDuplicate(User user) {
		UserDao emailDup = new UserDao();
		return emailDup.emailDuplicate(user.getEmail());
	}
	
	public boolean ToSChecker(String value) {
		return (value != null && value.length()>0);
	}
}
