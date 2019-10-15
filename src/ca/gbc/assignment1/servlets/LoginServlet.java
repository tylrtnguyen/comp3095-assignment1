package ca.gbc.assignment1.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gbc.assignment1.User;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import utilities.LoginDao;
import utilities.VerifyRecaptcha;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
       
    public LoginServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get request parameters for userID and password
				String username = request.getParameter("userName");
				String pwd = request.getParameter("password");
				String errorMessage="";
				
				// Create user object
				User user = new User();
				loginDao = new LoginDao();
				user.setUsername(username);
				user.setPassword(pwd);
				
				// get reCAPTCHA request param
				String gRecaptchaResponse = request
						.getParameter("g-recaptcha-response");
				System.out.println(gRecaptchaResponse);
				boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

				
				// logging example using loginDao object
				System.out.println("User=" + user.getUsername() + "::password=" + user.getPassword() + "::Captcha Verify"+verify);
				if(username != null && username.length() > 0 && pwd != null && pwd.length()>0) {
					// Credentials Validation
					if (loginDao.validate(user) && verify) {
						//Role Validation
						// Forward to home.jsp
						request.getRequestDispatcher("home.jsp").forward(request, response);
					} 
					else if(!loginDao.validate(user)) {
						errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
								"  Invalid Credentials Provided!" + 
								"</div>";
					}
					else {
						errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
								"  Please verify the reCAPTCHA" + 
								"</div>";
					}
					// Send error message to the user login page
					request.setAttribute("errorMessage", errorMessage);
					request.getRequestDispatcher("login.jsp").include(request,response);
				}
				else {
					errorMessage = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
							"  Username and Password cannot be blank" + 
							"</div>";
					// Send error message to the user login page
					request.setAttribute("errorMessage", errorMessage);
					request.getRequestDispatcher("login.jsp").include(request,response);
				}
				System.out.println(loginDao.validate(user));
				
	}	
}