<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<a href="login.jsp">Login</a>
	<br>
	<br>
	<h1>Registration</h1>

	<form action="registration" method="post">
		User Name: <input type="text" name="userName" required="required"> <br>
		Password: <input type="password" name="password" required="required">
		<br> <input type="submit" value="Register">
	</form>

</body>
</html>