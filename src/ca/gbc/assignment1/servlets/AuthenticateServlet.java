package ca.gbc.assignment1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.gbc.assignment1.User;
import utilities.UserDao;
import utilities.VerifyRecaptcha;

/**
 * Servlet implementation class AuthenticateServlet
 */
@WebServlet("/AuthenticateServlet")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthenticateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		System.out.println(gRecaptchaResponse);
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

		
		// Using UserDao object to login
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
				
				User infoUser = loginDao.getUser(email);
				// Session and Cookie creation
				HttpSession session = request.getSession();
				session.setAttribute("auth", true);
				session.setAttribute("name",infoUser.getFirstName());
				session.setAttribute("role",role);
				session.setMaxInactiveInterval(30*60);
				Cookie userName = new Cookie("name", infoUser.getFirstName());
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				// Forward to home.jsp
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
