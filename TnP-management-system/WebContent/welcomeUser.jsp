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
<style><%@include file="/res/css/welcomeUser.css"%></style>
</head>

<body>
<div class="form-center" align="center">
  <div class="half" align="center">
  <p> TnP Management System</p>
	<div class="mb-4 btn-lg btn-light btn-block" align="center">
				<a href="login.jsp" class="btn btn-success">LOGIN</a>
			</div>
	<div class=" btn-lg btn-light btn-block"  align="center">
				<a href="signup.jsp" class="btn btn-success">SIGNUP</a>
			</div>
	</div>		
</div>	
</body>
</html>