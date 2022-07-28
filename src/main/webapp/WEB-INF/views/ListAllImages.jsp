<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Images</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Image</th>
			<th>UserId</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${profile }" var="p">
			<tr>
				<td><img src="${p.imgUrl}" height="200px" width="200px"></td>
				<td>${p.userId}</td>
				<td>Delete</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
