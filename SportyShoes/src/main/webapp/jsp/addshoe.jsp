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

	<form:form id="newShoe" modelAttribute="newshoe" action="newShoeinfo"
		method="post">

		<table align="center">
			<tr>
				<td><form:label path="id">Shoe Id</form:label></td>
				<td><form:input path="id" name="id" id="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Shoe Name</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Category</form:label></td>
				<td><form:input path="category" name="category" id="category" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" name="price" id="price" /></td>
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