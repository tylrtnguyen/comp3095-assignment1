<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootswatch CDN -->
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/minty/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-9NlqO4dP5KfioUGS568UFwM3lbWf3Uj3Qb7FBHuIuhLoDp3ZgAqPE1/MYLEBPZYM" crossorigin="anonymous">
 <link rel="icon" type="image/png" href="https://img.icons8.com/dusk/64/000000/hearts.png"> 
<title>Plus 84's Members</title>
</head>
<body>
<!-- Navigation Bar -->
<%@include file="includes/navigation.jsp" %>
	<div class="container">
        <h2>Our group's members:</h2>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Student ID</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Thanh</td>
                    <td>Quan</td>
                    <td>101142560</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Thong</td>
                    <td>Nguyen</td>
                    <td>101140366</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Vo Anh Tu</td>
                    <td>Nguyen</td>
                    <td>101148412</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>Quang</td>
                    <td>Pham</td>
                    <td>101136246</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>Milad</td>
                    <td>Esmailpour</td>
                    <td>101124172</td>
                </tr>
                <tr>
                    <th scope="row">6</th>
                    <td>Parisa</td>
                    <td>Khataei</td>
                    <td>101111190</td>
                </tr>
          </tbody>
    </table>
    </div>s
</body>
</html>