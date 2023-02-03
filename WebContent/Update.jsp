<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h3>${message}</h3> <br>
<form action = "update" method ="post">  
Email id :  <input type="text"  name="verifyemail" required/> <br> <br>
New Email id :  <input type="text"  name="email" /> <br> <br>
Name :<input type="text" name="name" /> <br> <br>   
Phone Number :<input type="text" name="phno" /> <br> <br>  
Date Of Birth : <input type ="date" name= "date_of_birth"/> <br>
Password : <input type = "text" name = "password"/><br> <br>
<input type="submit"/> </form>

</body>
</html>