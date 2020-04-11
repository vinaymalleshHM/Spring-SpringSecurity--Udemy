<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login page</title>
</head>
<body>

	<h3>My Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!-- Check for login error -->

		<c:if test="${param.error != null}">
		<i style="color:red">Sorry! You Entered Invalid Username/Password.</i>
		</c:if>



		<p>
			User Name : <input type="text" name="username" />
		</p>

		<p>
			Password : <input type="password" name="password" />
		</p>

		<input type="submit" value="login">

	</form:form>

</body>
</html>