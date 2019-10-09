<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<title>Login Page</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
<style>
	div .container form{
		margin-top:5	
	}
</style>
</head>
<body>
	<div class="container">
       <h1>LOGIN</h1>
       <form action="LoginServlet" method="POST">
       			${errorMessage}
              <div class="form-group">
                    <label for="userName"></label>
                    <input type="text" name="email" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
                    <label for="Password">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password">
              </div>
              <!-- Google Captcha -->
              <div class="g-recaptcha" data-sitekey="6LdxaLwUAAAAABSmeSGd3gYONEUsKdV6fql5AuKh"></div>
                    <button type="submit" name="btnLogin" class="btn btn-primary">Login</button>
                    <button type="submit" name="btnRegister" class="btn btn-primary">Register</button>
               <div class="form-group">
                    <a href="a">Forgot your password?</a>
               </div>
         </form>
    </div>
</body>
</html>