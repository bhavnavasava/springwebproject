<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question page</title>
</head>
<body>
<form method="post" action="updatequestion">
		Question : <select name="SQuestion">
			<option value="Your mother's BirthPlace">Your mother's BirthPlace</option>
			<option value="First Bank Who Provide CreditCard">First Bank Who Provide CreditCard</option>
			<option value="First Job Company Name">First Job Company Name</option>
		</select> <br><br> 
		Answer : <input type="text" name="QAnswer"><br><br> 
		<input type="submit" value="SetQuestion" />
	</form>

</body>
</html>