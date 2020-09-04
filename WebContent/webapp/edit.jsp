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
	<h1>Edit</h1>
	<form action="edit" method="post">
		<input type="text" name="title" placeholder="title" value="${todos.getTitle()}"><br>
		<input type="date" name="date" placeholder="date" value="${todos.getDate()}"><br>
		<input type="submit" name="" value="OK" class="ok">
	</form>
</div>
<%@ include file="font-end/footer.jsp" %>
</body>
</html>