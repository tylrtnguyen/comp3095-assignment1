package ca.gbc.assignment1.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gbc.assignment1.User;
import utilities.EmailHandling;
import utilities.UserDao;
import utilities.Validators;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: Registration Servlet is responsible for validating
 * users' information when they register for a new account and send
 * a confirmation email for user when they successfully registered
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String cfPassword = request.getParameter("cfPassword");
		String ToSValue = request.getParameter("ToSChecker");
		String errorMessage = "";
		String starMark = "<span style='color:Red;'>*</span>";
		
		// Create and set properties for the new project
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setAddress(address);
		Validators validator = new Validators();
		UserDao registerDao = new UserDao();
		
		
		//Validate Part
		if(validator.nullValidator(newUser)) {
			if(validator.nameValidator(newUser) && validator.pwValidator(newUser) && 
					validator.pwMatchValidator(password, cfPassword) 
					&& validator.ToSChecker(ToSValue) && !validator.emailDuplicate(newUser)) {
				// Insert into database
				registerDao.registerUser(newUser);
				registerDao.insertRole(newUser);
				request.setAttribute("fullName",firstName+ " "+lastName);
				request.setAttribute("email", email);
				EmailHandling newEmail = new EmailHandling();
				try {
					newEmail.SendEmail(newUser);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("registrationSuccess.jsp").forward(request, response);
			}
			else if(!validator.nameValidator(newUser)) {
				errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
						"  First name and Last name can only contain characters" + 
						"</div>";
			}
			else if(!validator.pwValidator(newUser)) {
				errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
						"<p> - Password must be 6 - 12 character</p>"
						+ "<p> - Password must have at least 1 special character</p>" +  
						"<p> - Password must have at least 1 uppercase character</p>" +
						"</div>";
			}
			else if(!validator.pwMatchValidator(password,cfPassword)) {
				errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
						"  Password and Confirm password don't match" + 
						"</div>";
			}
			else if (validator.emailDuplicate(newUser)) {
				errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
						" The email you entered has been used" + 
						"</div>";
			}
			else if (!validator.ToSChecker(ToSValue)) {
				errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
						" Please agree to Terms of Service" + 
						"</div>";
			}
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("register.jsp").include(request,response);
		}
		else {
			errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
					"  Fields Marked with * are mandatory" + 
					"</div>";
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("starMark", starMark);
			request.getRequestDispatcher("register.jsp").include(request,response);
		}
		
	}

}
