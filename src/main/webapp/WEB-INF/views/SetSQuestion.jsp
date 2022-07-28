<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Question-ans</title>
</head>
<body>
	<form method="post" action="savequestion">
		Question : <select name="SQuestion">
			<option value="Your mother's BirthPlace">Your mother's
				BirthPlace</option>
			<option value="First Bank Who Provide CreditCard">First Bank
				Who Provide CreditCard</option>
			<option value="First Job Company Name">First Job Company
				Name</option>
		</select> <br> <br> Answer : <input type="text" name="QAnswer"><br>
		<br> <input type="submit" value="SetQuestion" />
	</form>
	<br><br>

	<table border="1">
		<tr>
			<th>Security Question</th>
			<th>Security ans</th>
			<th>userId</th>
		</tr>
		<c:forEach items="${question}" var="q">

			<tr>
				<td>${q.SQuestion}</td>
				<td>${q.QAnswer}</td>
				<td>${q.userId}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>