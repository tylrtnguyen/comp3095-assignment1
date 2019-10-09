package ca.gbc.assignment1.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gbc.assignment1.VerifyRecaptcha;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get request parameters for userID and password
				String user = request.getParameter("email");
				String pwd = request.getParameter("password");
				// get reCAPTCHA request param
				String gRecaptchaResponse = request
						.getParameter("g-recaptcha-response");
				System.out.println(gRecaptchaResponse);
				boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

				// get servlet config init params
				String userID = getServletContext().getInitParameter("user");
				String password = getServletContext().getInitParameter("password");
				// logging example
				System.out.println("User=" + userID + "::password=" + password + "::Captcha Verify"+verify);

				if (userID.equals(user) && password.equals(pwd) && verify==true) {
					request.getRequestDispatcher("home.jsp").forward(request, response);
				} 
				else {
					String message = "<div class=\"alert alert-danger\" role=\"alert\">\n" + 
							"  Invalid Credentials Provided!" + 
							"</div>";
					request.setAttribute("errorMessage", message);
					request.getRequestDispatcher("login.jsp").include(request,response);
					
				}
	}
}
