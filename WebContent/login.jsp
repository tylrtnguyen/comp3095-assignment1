<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootswatch CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous">
<title>Login Page</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
<style>
	div .container form{
		margin-top:10;
	}
</style>
</head>
<body>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
       <h1>LOGIN</h1>
       <form action="LoginServlet" method="POST">
       			${errorMessage}
              <div class="form-group">
                    <label for="Email">Email</label>
                    <input type="email" name="email" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
                    <label for="Password">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password">
              </div>
              <!-- Google Captcha -->
              <div class="g-recaptcha" data-sitekey="6LdxaLwUAAAAABSmeSGd3gYONEUsKdV6fql5AuKh"></div>
                    <button type="submit" name="btnLogin" class="btn btn-primary">Login</button>
                    <a href="register.jsp"><button type="button" name="btnRegister" class="btn btn-primary">Register</button></a>
               <div class="form-group">
                    <a href="">Forgot your password?</a>
               </div>
         </form>
    </div>
    <!-- Footer -->
	<%@include file="includes/footer.jsp" %>
</body>
</html>