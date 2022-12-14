<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List users</title>
</head>
<body>
<h2>List Users</h2>
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Password</th>
			<th>UserType</th>
			<th>Action</th>

		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td>${u.lastName}</td>
				<td>${u.email}</td>
				<td>${u.password}</td>
				<td>${u.userType}</td>
				<td><a href="Deleteuser?userId=${u.userId}">Delete</a> 
				|<a href="viewuser?userId=${u.userId}">View</a>
				|<a href="edituser?userId=${u.userId}">Update</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>