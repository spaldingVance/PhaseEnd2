<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="registration.jsp">Register</a>
	<h1>Login</h1>

	<form action="login" method="post">
		User Name: <input type="text" name="userName" required="required"> <br>
		Password: <input type="password" name="password" required="required">
		<br> <input type="submit" value="Login">
	</form>
</body>
</html>