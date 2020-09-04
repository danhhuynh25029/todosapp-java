<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>todoslist</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/webapp/css/style.css' />"/>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/webapp/css/fontawsome/css/all.css"/>
</head>
<body>
<%@ include file="font-end/header.jsp" %>
<div class="content">
	<form class="input" action="insert" method="post">
	<input type="text" name="content" class="title" >
	<input type="date" name="date">
	<input type="submit" value="Add">
	</form>
	<div class="title">
		<table>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${list}" var="item">
			<tr>
			<c:if test="${item.getDone() == 1 }">
				<td style="text-decoration: line-through;">${item.getTitle()}</td>
				<td>${item.getDate()}</td>
				<td><a href="done?title=${item.getTitle()}&date=${item.date}&done=0" class="check"><i class="fas fa-times"></i></a><a href="edit?title=${item.getTitle()}" class="edit">Edit</a><a href="delete?title=${item.getTitle()}" class="delete">Delete</a></td>
			</c:if>
			<c:if test="${item.getDone() == 0 }">
				<td>${item.getTitle()}</td>
			
				<td>${item.getDate()}</td>
				<td><a href="done?title=${item.getTitle()}&date=${item.date}&done=1" class="check"><i class="fas fa-check"></i></a><a href="edit?title=${item.getTitle()}" class="edit">Edit</a><a href="delete?title=${item.getTitle()}" class="delete">Delete</a></td>
			</c:if>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
<%@ include file="font-end/footer.jsp" %>
</body>
</html>