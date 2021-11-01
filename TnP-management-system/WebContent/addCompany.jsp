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
<style><%@include file="/res/css/addCompany.css"%></style>
</head>

<body>
<nav class="navbar fixed-top navbar-light bg-dark ">
  <div class="container-fluid">
   <div class="navbar-header">
    <a class="navbar-brand " href="<%=request.getContextPath()%>/home"><span class="header">TnP Management System</span></a>
    </div>
    <div class="navitems">
      <a href="welcome page"><span >Logout</span> </a>
    </div>
   </div>
</nav>
<form action="add-company" method="post" class ="form">
  <div class="form-group">
       
  <div class="form-row">
     <div class="form-group col-md-6">
      <label for="name">Name</label>
      <input type="text" name="name" class="form-control" id="name" placeholder="Name" required>
    </div>
    <div class="form-group col-md-6">
      <label for="role">Role</label>
      <input type="text" class="form-control" id="role" name="role" placeholder="Role" required>
    </div>
  </div>
  </div>
  <div class="form-group">
    <label for="ctc">CTC</label>
    <input type="text" class="form-control" id="ctc" name="ctc" placeholder="CTC">
  </div>
  <div class="form-group">
    <label for="loc">Location</label>
    <input type="text" class="form-control" id="loc" name="loc"  placeholder="Location">
  </div>
 
   

  <button type="submit" class="btn btn-primary mt-3">Add</button>
</form>
</body>
</html>