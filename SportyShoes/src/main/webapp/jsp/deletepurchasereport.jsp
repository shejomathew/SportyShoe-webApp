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

<form:form id="removepurchasereport" modelAttribute="removepurchasereport"
		action="deletepurchasereportinfo" method="post">

		<table align="center">
			<tr>
				<td><form:label path="id">Purchase Report Id</form:label></td>
				<td><form:input path="id" name="id" id="id" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="delete" name="delete">Delete</form:button></td>
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