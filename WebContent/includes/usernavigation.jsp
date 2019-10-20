<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="login.jsp">Plus84</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="members.jsp">Members</a>
      </li>
    </ul>
    <form action="LoginServlet" class="form-inline my-2 my-lg-0">
		  <button type="button" class="btn btn-primary">Hello, ${name}</button>
      <button type="submit" class="btn btn-secondary my-2 my-sm-0">Logout</button>
    </form>
  </div>
</nav>