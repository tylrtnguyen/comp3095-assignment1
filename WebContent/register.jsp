<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous">
    <title>Register</title>
    <style>
        .container{
            margin:2% 20%;
        }
        h1{
            margin:2% 20%;
        }
    </style>
</head>
<body>
	<%@include file="includes/navigation.jsp" %>
    <h1>REGISTRATION PAGE</h1>
   
    <div class="container">
        <!-- Page Title -->
            
        <!-- Form begins -->
          <form action="RegistrationServlet" method="POST">
          ${errorMessage}
          <div class="form-row">
             <div class="form-group col-md-6">
                  <label for="FirstName">First Name${starMark}</label>&nbsp;
                  <input type="text" class="form-control" name="firstName" placeholder="First Name"></input>
             </div>
             <div class="form-group col-md-6">
                  <label for="LastName">Last Name${starMark}</label>&nbsp;
                  <input type="text" class="form-control" name="lastName" placeholder="Last Name">
            </div>
            </div>
            <div class="form-group">               
                <label for="Address">Address${starMark}</label>            
            	<input type="text" class="form-control" name="address" placeholder="Address">
            </div>
            <div class="form-group">               
                <label for="Email">Email${starMark}</label>            
            	<input type="email" class="form-control" name="email" placeholder="Email">
            </div>
              <div class="form-group">               
                <label for="Email">Password${starMark}</label>            
            	<input type="password" class="form-control" name="password" placeholder="Password">
            </div>
              <div class="form-group">
                <label for="confirmPassword">Confirm Password${starMark}</label>
                <input type="password" class="form-control" name="cfPassword" placeholder="Confirm Password">
            </div>
            <div class="form-group row">
              <div class="col-sm-10">
                <div class="form-check">
                    <input type="checkbox" name="ToSChecker" value="checked " class="form-check-input"/>
                    <label class="form-check-label" for="ToSCheker">
                    I agree to <a href="#">terms of service</a>
                    </label>
                </div>
              </div>
           </div> 
          <button type="submit" class="btn btn-primary" name="btnRegister">Register</button>
          <button class="btn btn-primary" name="btnCancel">Cancel</button>
        </form>
    <!-- Form ends -->
    </div>
    <!-- Footer -->
<%@include file="includes/footer.jsp" %>
</body>
</html>
