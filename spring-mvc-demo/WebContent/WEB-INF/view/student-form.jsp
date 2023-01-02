<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name : <form:input path="firstName" />
		<br>
		<br>
	Last Name : <form:input path="lastName" />

		<br>
		<br>
		
		Country : 
		<form:select path="country">


			<form:options items="${student.countryOptions}" />

		</form:select>

		<br>
		<br>

		Favourate Language:

		Java  <form:radiobutton path="favourateLanguage" value="Java" />
		Go  <form:radiobutton path="favourateLanguage" value="Go" />
		Python  <form:radiobutton path="favourateLanguage" value="Python" />
		Ruby  <form:radiobutton path="favourateLanguage" value="Ruby" />
		<br>
		<br>
		
		Operating System :
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
		
		<br> <br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>