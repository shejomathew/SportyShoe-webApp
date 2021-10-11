<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<table>
		<tr>
			<td>Welcome ${username}</td>
		</tr>
	</table>

	<table align="center">

		<tr>
			<td><a href="addnewshoe">Add New Product</a></td>
		</tr>

		<tr>
			<td><a href="findshoe">Search Available Shoes</a></td>
		</tr>

		<tr>
			<td><a href="delete">Delete A Product</a></td>
		</tr>

		<tr>
			<td><a href="addpurchase">Add a Purchase Report</a></td>
		</tr>

		<tr>
			<td><a href="deletepurchase">Delete a Purchase Report</a></td>
		</tr>

		<tr>
			<td><a href="getreport">Get Purchase Report</a></td>
		</tr>

		<tr>
			<td><a href="logout">Log Out</a></td>
		</tr>

		<tr>
			<td style="font-style: italic; color: green;">${message}</td>
		</tr>
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>


	</table>

</body>
</html>