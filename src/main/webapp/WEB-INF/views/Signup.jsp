<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h2>Signup Page</h2>
	<!-- <form action="saveuser" method="post">
		FirstName: <input type="text" name="firstName"><br><br> 
		LastName: <input type="text" name="lastName"><br><br> 
		Email: <input type="text" name="email"><br><br> 
		<input type="submit">
	</form> -->
	
	<s:form action="saveuser" method="post" modelAttribute="user">
	FirstName:<s:input path="firstName" />
		<s:errors path="firstName"></s:errors>
		<br>
		<br>
	LastName:<s:input path="lastName" />
		<s:errors path="lastName"></s:errors>
		<br>
		<br>
	Email:<s:input path="email" />
		<s:errors path="email"></s:errors>
		<br>
		<br>
	Password:<s:input path="password" />
		<s:errors path="password"></s:errors>
		<br>
		<br>
		<input type="submit">
	</s:form>

</body>
</html>