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
		<h1>Purchase Report</h1>

		<table border="1" cellpadding="5">
			<tr>
				<th>Purchase Id</th>
				<th>Customer Name</th>
				<th>Category</th>
				<th>Date of Purchase</th>
				<th>Order List</th>
				
			</tr>
			<c:forEach items="${purchasereportlist}" var="pr" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${pr.purchasedBy}</td>
					<td>${pr.category}</td>
					<td>${pr.dop}</td>
					<td>${pr.orderList}</td>
					
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>