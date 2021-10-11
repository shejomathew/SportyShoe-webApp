<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form id="newpurchasereport" modelAttribute="newpurchasereport" action="newpurchasereportinfo"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="id">Purchase Report Id</form:label></td>
				<td><form:input path="id" name="id" id="id" /></td>
			</tr>
			<tr>
				<td><form:label path="purchasedBy">Customer Name</form:label></td>
				<td><form:input path="purchasedBy" name="purchasedBy" id="purchasedBy" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Category</form:label></td>
				<td><form:input path="category" name="category" id="category" /></td>
			</tr>
			<tr>
				<td><form:label path="dop">Date of Purchase</form:label></td>
				<td><form:input path="dop" name="dop" id="dop" /></td>
			</tr>
			<tr>
				<td><form:label path="orderList">Order List</form:label></td>
				<td><form:input path="orderList" name="orderList" id="orderList" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><form:button id="add" name="add">Add</form:button></td>
			</tr>
		</table>

	</form:form>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>
	</table>

</body>
</html>