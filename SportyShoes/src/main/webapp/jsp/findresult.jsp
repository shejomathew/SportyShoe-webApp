<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body>
	<div align="center">
		<h1>Shoes List</h1>

		<table border="1" cellpadding="5">
			<tr>
				<th>Shoe Id</th>
				<th>Shoe Name</th>
				<th>Category</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${shoelist}" var="shoe" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${shoe.name}</td>
					<td>${shoe.category}</td>
					<td>${shoe.price}</td>
					
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>