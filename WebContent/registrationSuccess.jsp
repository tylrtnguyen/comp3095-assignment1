<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous">
<!-- CSS file -->
<link rel="stylesheet" href="assets/style.css">
<title>Confirmation Page</title>
</head>
<body>
<!-- Navigation Bar -->
<%@include file="includes/navigation.jsp" %>
	<div class=content>
  <div class="wrapper-1">
    <div class="wrapper-2">
      <h1>Congratulations! ${fullName}</h1>
      <h4>An email has been sent to ${email} to verify and confirm</h4>
      <a href="login.jsp"><button class="btn btn-primary">Login</button></a>
    </div>
</div>
</div>
    <!-- Footer -->
<%@include file="includes/footer.jsp" %>
</body>
</html>