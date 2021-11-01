<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
<head>
<meta name="author" content="Rameez Naufal" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>TnP Management System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet" 
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
      crossorigin="anonymous"/>
<style><%@include file="/res/css/signup.css"%></style>
</head>

<body>
<nav class="navbar fixed-top navbar-light bg-dark ">
  <div class="container-fluid">
   <div class="navbar-header">
    <a class="navbar-brand " href="welcome page"><span class="header">TnP Management System</span></a>
    </div>
   </div>
</nav>
<form action="signup" method="post" class ="form">
  <div class="form-group">
       
  <div class="form-row">
     <div class="form-group col-md-6">
      <label for="name">Name</label>
      <input type="text" name="name" class="form-control" id="name" placeholder="Name" required>
    </div>
    <div class="form-group col-md-6">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
    </div>
  </div>
  </div>
  <div class="form-group">
    <label for="regno">Registration No.</label>
    <input type="text" pattern=".{9,9}" required title="Reg. No should contain 9 characters" class="form-control" id="regNo" name="regNo" placeholder="reg no">
  </div>
  <div class="form-group">
    <label for="phno">Phone No</label>
    <input type="text" pattern=".{10,10}" required title="Phone No should contain 10 characters" class="form-control" id="phno" name="phNo"  placeholder="phone number">
  </div>
  <div class="form-group">
    <label for="phno">CGPA</label>
    <input type="number" min="0" max="10" step="0.01" required title="CGPA should be within 0-10" class="form-control" id="cgpa" name="cgpa"  placeholder="CGPA">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="text" class="form-control" id="password" name="password"  placeholder="password" required>
  </div>
   

  <button type="submit" class="btn btn-primary mt-3">Signup</button>
</form>
</body>
</html>