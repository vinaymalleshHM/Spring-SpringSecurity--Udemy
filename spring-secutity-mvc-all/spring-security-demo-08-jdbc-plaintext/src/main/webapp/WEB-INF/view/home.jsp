<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page</h1>
	<hr>
	welcome to Home Page

	<hr>

	<!-- Display User Name and Role -->
	<p>
		User :
		<security:authentication property="principal.username" />
		<br> <br> Role(s) :
		<security:authentication property="principal.authorities" />
	</p>

	<hr>
	
	<security:authorize access="hasRole('MANAGER')">

	<!-- Add a link to point to /leaders ... this is for the managers -->

	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip
			Meeting</a> (only for Manager peeps)
	</p>
	
	<hr>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
	<!-- Add a link to point to /systems ... this is for the Admins -->

	<p>
		<a href="${pageContext.request.contextPath}/systems">IT System
			Meeting</a> (only for Admin peeps)
	</p>
	
	<hr>
	</security:authorize>
	


	<!-- Add a Logout Button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>