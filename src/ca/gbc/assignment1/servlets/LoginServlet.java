package ca.gbc.assignment1.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.gbc.assignment1.User;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import utilities.UserDao;
import utilities.VerifyRecaptcha;

/**
 * Project: Client Tracker
 * Assignment: Assignment 1
 * Author: Thong Nguyen
 * Student Number: 101140366
 * Date: Oct 20th, 2019
 * Description: Login Servlet is responsible for user login page, 
 * and the Log out function of the application
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
        response.sendRedirect("/COMP3095_Plus84");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
}