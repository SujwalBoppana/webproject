<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>  
<h2>${message}</h2>
<h3> Registration Form</h3>
<form action = "register" method ="post">  
 Name :<input type="text" name="name"  required/> <br> <br>   
Phone Number :<input type="text" name="phone" required/> <br> <br>  
Email id :  <input type="text"  name="email" required/> <br> <br>
Date Of Birth : <input type ="date" name= "dob" required/><br> <br>
password : <input type="password" name = "pwd" required/><br> <br>
<input type="submit"/>  
</form>

</head>
<body>

</body>
</html>