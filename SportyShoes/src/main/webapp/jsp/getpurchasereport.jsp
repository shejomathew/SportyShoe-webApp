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

<form:form id="getreport" modelAttribute="getreport"
		action="findreportprocess" method="post">

		<table align="center">
			<tr>
				<td><form:label path="id">Search By Id</form:label></td>
				<td><form:input path="id" name="id" id="id" /></td>
			</tr>
			<tr>
				<td><form:label path="dop">Search By Date Of Purchase</form:label></td>
				<td><form:input path="dop" name="dop" id="dop" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Search By Category</form:label></td>
				<td><form:input path="category" name="category" id="category" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="search" name="search">Search</form:button></td>
			</tr>
		</table>

	</form:form>
	
	<table align="center">
		<tr>
			<td><a href="allreport">See all Reports</a></td>
		</tr>
	</table>
	
	
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>
	</table>

</body>
</html>