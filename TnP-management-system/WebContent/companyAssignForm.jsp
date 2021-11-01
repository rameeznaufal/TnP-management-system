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
<style><%@include file="/res/css/companyAssignForm.css"%></style>
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

<form action="assigned" method="post" class ="form">
 
  <input type="hidden" name="c_id" value="${company.id}" class="form-control" id="c_id">
 
 <div class="list-group" >
  <c:forEach var="user" items="${listStudent}">
  <div class="item" id=<c:out value="${user.name}"/>>
    <div class="list-group-item list-group-item-action active" aria-current="true">
      <div class="d-flex w-100 justify-content-between">
       <h2 class="mb-0"><c:out value="${user.name}"/></h2>
      </div>
    <p class="mb-1">Reg No: <c:out value="${user.regNo}"/></p>
    <p class="mb-0">Email: <c:out value="${user.email}"/></p>
    <p class="mb-0">CGPA: <c:out value="${user.cgpa}"/></p>
    <p class="mb-0">Phone No: <c:out value="${user.phNo}"/></p>
    <p class="mb-0">placStat: <c:out value="${user.placStat}"/></p>
    <p class="mb-1 mt-0">placComp: <c:out value="${user.placComp}"/></p>
    <div class="form-check">
  <input class="form-check-input" type="checkbox" name="id" value="${user.id}" id="id"/>
  <label class="form-check-label" for="id">
    Check to Assign Student
  </label>
  </div>
    </div>
   </div>

   
   </c:forEach> 
  
 
 
  </div>
   <button type="submit" class="btn btn-primary mt-3 " >Assign</button>
</form>
</body>
</html>