<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>      
<%@page import="java.util.Iterator"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data </title>
</head>
<body>
<h2>${message}</h2>
<c:forEach items="${details}" var="listOfDetails">
		<p>Name: ${listOfDetails.name}, Phone: ${listOfDetails.phno}, Email: ${listOfDetails.email}, DOB: ${listOfDetails.date_of_birth}, Age: ${listOfDetails.age}</p>
	</c:forEach>
	<form action = "getall" method ="post">  
Get all  data <input type ="submit">
</form>
</body>
</html>