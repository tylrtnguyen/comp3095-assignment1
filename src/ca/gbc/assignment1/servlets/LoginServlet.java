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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("login.jsp").include(request, response); 
		 HttpSession session = request.getSession();
		 session.invalidate();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get request parameters for userID and password
				String email = request.getParameter("email");
				String pwd = request.getParameter("password");
				String errorMessage="";
				
				// Create user object
				User user = new User();
				UserDao loginDao = new UserDao();
				user.setEmail(email);
				user.setPassword(pwd);
				
				// get reCAPTCHA request param
				String gRecaptchaResponse = request
						.getParameter("g-recaptcha-response");
				System.out.println(gRecaptchaResponse);
				boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

				
				// logging example using loginDao object
				System.out.println("User=" + user.getEmail() + "::password=" + user.getPassword() + "::Captcha Verify"+verify);
				if(email != null && email.length() > 0 && pwd != null && pwd.length()>0) {
					// Credentials Validation
					if (loginDao.validate(user) && verify) {
						//Role Validation
						Integer roleID = loginDao.getRoleID(user);
						if(roleID == 1) {
							HttpSession session = request.getSession();
							session.setAttribute("email", email);
						}
						String path = (roleID == 1) ? "adminhome.jsp" : "userhome.jsp";
						String role = path.equals("adminhome.jsp") ? "Admin" : "User";
						// Forward to home.jsp
						user = loginDao.getUser(email);
						request.setAttribute("role", role);
						request.setAttribute("name", user.getFirstName());
						request.getRequestDispatcher(path).forward(request, response);
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