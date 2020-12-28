<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome <%
	session.getAttribute("userName");
%></title>
</head>
<body>
	<div>
		<%
			if (session.getAttribute("userName") != null) {
			out.print("<a href='logout'>Logout</a>");
			out.println("<h2>Welcome " + session.getAttribute("userName") + "!</h1>");	
			}
			else if (session.getAttribute("userName") == null) {
				out.println("<p>You must be logged in to view this page!<p>");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		%>
	</div>
</body>
</html>