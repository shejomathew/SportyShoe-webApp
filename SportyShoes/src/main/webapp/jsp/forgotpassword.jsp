<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form id="changepassword" modelAttribute="newcredentials"
		action="resetpassword" method="get">
		<table align="center">
			<tr>
				<td><form:label path="username">Enter Your Username</form:label></td>
				<td><form:input path="username" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">New password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="confirmpassword">Confirm password</form:label></td>
				<td><form:password path="confirmpassword"
						name="confirmpassword" id="confirmpassword" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="submit" name="submit">Submit</form:button></td>
			</tr>

			<tr></tr>
		</table>

	</form:form>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>
	</table>

</body>
</html>