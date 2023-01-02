<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

	The Student is confirmed : ${student.firstName} ${student.lastName}


	<br>
	<br> Country: ${student.country}

	<br>
	<br> Your Favourate Language : ${student.favourateLanguage}

	<br>
	<br>
	
	Operating Systems:
	<ul>
	<c:forEach var="temp" items="${student.operatingSystems }">
		<li>${temp}
	</c:forEach>
	
	</ul>
	

</body>
</html>