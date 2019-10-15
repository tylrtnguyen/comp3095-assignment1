<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
    <title>Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/lux/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-hVpXlpdRmJ+uXGwD5W6HZMnR9ENcKVRn855pPbuI/mwPIEKAuKgTKgGksVGmlAvt" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
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
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
           <div class="container-fluid">
                    <a class="navbar-brand" href="Home">Plus84</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
               <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav navbar-right">                   
                    <li class="nav-item">
                        <a class="nav-link" href="Members">Members</a>
                    </li>
                </ul>
            </div>
          </div>
       </nav>
    <h1>REGISTRATION PAGE</h1>
   
    <div class="container">
        <!-- Page Title -->
            
        <!-- Form begins -->
          <form action="">
          ${errorMessage}
          <div class="form-row">
             <div class="form-group col-md-6">
                  <label for="FirstName">First Name</label>&nbsp;
                  <input type="text" class="form-control" name="firstName" placeholder="First Name"></input>
             </div>
             <div class="form-group col-md-6">
                  <label for="LastName">Last Name</label>&nbsp;
                  <input type="text" class="form-control" name="lastName" placeholder="Last Name">
            </div>
            </div>
            <div class="form-group">               
                <label for="Address">Address</label>            
            	<input type="text" class="form-control" name="address" placeholder="Address">
            </div>
            <div class="form-group">               
                <label for="Email">Email</label>            
            	<input type="email" class="form-control" name="email" placeholder="Email">
            </div>
              <div class="form-group">               
                <label for="Email">Password</label>            
            	<input type="password" class="form-control" name="password" placeholder="Password">
            </div>
              <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" class="form-control" name="password" placeholder="Confirm Password">
            </div>
            <div class="form-group row">
              <div class="col-sm-10">
                <div class="form-check">
                    <input type="checkbox" name="ToSChecker" class="form-check-input"/>
                    <label class="form-check-label" for="ToSCheker">
                    I agree to <a href="#">terms of service</a>
                    </label>
                </div>
              </div>
           </div> 
          <button ID="btnRegister" class="btn btn-primary" name="btnRegister">Register</button>
          <button ID="btnCancel" class="btn btn-primary" name="btnCancel">Cancel</button>
        </form>
    <!-- Form ends -->
    </div>
</body>
</html>
