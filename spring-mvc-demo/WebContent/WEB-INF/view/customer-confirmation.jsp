<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Confirmation</title>
</head>
<body>The Customer is confirmed: ${customer.firstName}
	${customer.lastName}
	
	<br> <br>
	Free Passes: ${customer.freePasses }
	
	<br> <br>
	Postal Code: ${customer.postalCode }
	
	<br> <br>
	Course Code: ${customer.courseCode }
</body>
</html>