package ca.gbc.assignment1;
import java.io.Serializable;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: User class is a JavaBean class which is responsible for 
 * providing a blueprint when working with user's information
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private String address;
    private String firstName;
    private String lastName;
    
    

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}
    
}
