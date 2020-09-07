<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/webapp/css/style.css"/>
</head>
<body>
<%@ include file="font-end/header.jsp" %>
<div class="login">
	<h1>Login Form</h1>
	<form action="login" method="post">
			<input type="text" name="username" placeholder="USERNAME" value="${user.getUsername()}"><br>
			<input type="password" name="password" placeholder="PASSWORD" value="${user.getPassword()}"><br>
			<input type="submit" name="" value="LOGIN">
		<a href="sign" class="sign">SIGN</a>
	</form>
</div>
<%@ include file="font-end/footer.jsp" %>
</body>
</html>