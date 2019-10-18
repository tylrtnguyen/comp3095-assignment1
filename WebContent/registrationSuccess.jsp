<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
<!-- CSS file -->
<link rel="stylesheet" href="assets/style.css">
<title>Confirmation Page</title>
</head>
<body>
	<div class=content>
  <div class="wrapper-1">
    <div class="wrapper-2">
      <h1>Congratulations! ${fullName}</h1>
      <h4>An email has been sent to ${email} to verify and confirm</h4>
      <a href="userhome.jsp"><button hre class="btn btn-primary">Login</button></a>
    </div>
</div>
</div>
</body>
</html>