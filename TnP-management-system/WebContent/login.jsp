<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta name="author" content="Rameez Naufal" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>TnP Management System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet" 
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
      crossorigin="anonymous"/>
<style><%@include file="/res/css/login.css"%></style>
</head>

<body>
 <nav class="navbar fixed-top navbar-light bg-dark ">
  <div class="container-fluid">
   <div class="navbar-header">
    <a class="navbar-brand " href="welcome page"><span class="header">TnP Management System</span></a>
    </div>
   </div>
</nav>

  <form action="login" method="post" class ="form pt-3">

  <div class="form-group mb-2">
    <label for="regno">Registration No</label>
    <input type="text" required title="Reg. No should contain 9 characters" class="form-control" id="regNo" name="regNo"  placeholder="reg no">
  </div>
 
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password"  placeholder="password" required>
  </div>
   <button type="submit" class="btn btn-success mt-3">Log In</button>             
       <c:if test="${(Err != null) && (Err == 1) }">
          <p class="err">*Invalid Login Details</p>
       </c:if>         
</form>
</body>
</html>