<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h1> Login Here</h1>
<h3>${message}</h3>
	<form action="login" method = "post">
	Email_id : <input type = "text" name = "username" required><br>
	password : <input type = "text" name = "password" required><br>
	<input type = "submit" value = "login">
	Not yet a member ? <a href ="registration.html">Register</a>
	</form>
</body>
</html>