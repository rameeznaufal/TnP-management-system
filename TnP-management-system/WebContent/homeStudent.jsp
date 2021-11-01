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
<style><%@include file="/res/css/homeStudent.css"%></style>
</head>

<body>
<nav class="navbar fixed-top navbar-light bg-dark ">
  <div class="container-fluid">
   <div class="navbar-header">
    <a class="navbar-brand " href="<%=request.getContextPath()%>/home"><span class="header">TnP Management System</span></a>
    </div>
    <div class="navitems">
      <a href="<%=request.getContextPath()%>/edit"><span><c:out value="${USER.name}"/></span></a> | <a href="welcome page"><span >Logout</span> </a>
    </div>
  </div>
</nav>
 <div class="sd"><p class="sdp"><c:out value="${USER.placStat}"/></p>
 <c:if test="${USER.placStat == 'PLACED' }">
           <h4 class="sdpv"><c:out value="${USER.placComp}"/></h4>
       </c:if> </div>
<div class="list-group">
  <c:forEach var="company" items="${listCompany}">
  <div class="item" id=<c:out value="${company.name}"/>>
   <div class="list-group-item list-group-item-action active" aria-current="true">
    <div class="d-flex w-100 justify-content-between">
    <c:set var="name" value="${fn:toUpperCase(company.name)}"/>
      <h2 class="mb-0"><c:out value="${name}"/></h2>
      <c:if test="${USER.placStat == 'NOT PLACED' }"> 
      <c:if test="${company.applied == true}">
         <div class="but"><p class="applied"> Applied</p></div>
      </c:if>
      <c:if test="${company.applied != true}">
        <div class="btn btn-dark"> <a href="<%=request.getContextPath()%>/apply?id=${company.id}" class="apply">Apply</a></div>
      </c:if>    
      </c:if>
       <c:if test="${USER.placStat == 'PLACED' }">
           <div class="but"><p class="applied"> ALREADY PLACED</p></div>
       </c:if> 
    </div>
    <p class="mb-1">Role: <c:out value="${company.role}"/></p>
    <p class="mb-0"><h6>CTC: <c:out value="${company.ctc}"/></h6></p>
    <p class="mb-1 mt-0">Location: <c:out value="${company.loc}"/></p>
   </div>
   </div>
   </c:forEach> 
  </div>

</body>
</html>