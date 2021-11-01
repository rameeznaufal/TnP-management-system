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
<style><%@include file="/res/css/homeAdmin.css"%></style>
</head>

<body>
<nav class="navbar fixed-top navbar-light bg-dark ">
  <div class="container-fluid">
   <div class="navbar-header">
    <a class="navbar-brand " href="<%=request.getContextPath()%>/home"><span class="header">TnP Management System</span></a>
    </div>
    <div class="navitems">
      <a href="addCompany.jsp"><span>Add</span></a> | <a href="<%=request.getContextPath()%>/edit"><span><c:out value="${USER.name}"/></span></a> | <a href="welcome page"><span >Logout</span> </a>
    </div>
  </div>
</nav>
<div class="list-group">
  <c:forEach var="company" items="${listCompany}">
  <div class="item" id=<c:out value="${company.name}"/>>
   <div class="list-group-item list-group-item-action active" aria-current="true">
   
    <div class="d-flex w-100 justify-content-start">
   <c:set var="name" value="${fn:toUpperCase(company.name)}"/>
    <div class="cname mr-auto pb-0 mb-0">  <p class="cnameh pb-0 mb-0"><c:out value="${name}"/></p></div>
     </div>  
         <div class="d-flex w-100 justify-content-start">      
        <div class="btn btn-dark  ml-0  mb-1 px-2 pt-1 pb-1"> <a href="<%=request.getContextPath()%>/assign?id=${company.id}" class="apply">Assign</a></div>  
         <div class="btn btn-dark mb-1 mx-3 px-2 pt-1 pb-1"> <a href="<%=request.getContextPath()%>/edit-company?id=${company.id}" class="apply">Edit</a></div>  
    </div>
    <p class="mb-1">Role: <c:out value="${company.role}"/></p>
    <p class="mb-0"><h6>CTC: <c:out value="${company.ctc}"/></h6></p>
    <p class="mb-1 mt-0">Location: <c:out value="${company.loc}"/></p>
   </div>
   </div>
   </c:forEach> 
  </div>
 
    
 
  <div class="list" >
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
    <p class="mb-0">Placement Status: <c:out value="${user.placStat}"/></p>
    <p class="mb-1 mt-0">Company Placed: <c:out value="${user.placComp}"/></p>
   </div>
   </div>
   </c:forEach> 
  </div>

</body>
</html>