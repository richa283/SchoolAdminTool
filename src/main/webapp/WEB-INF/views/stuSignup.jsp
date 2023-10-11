<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Enrollment</title>
</head>

<body>
	<jsp:include page="../../verMenu.jsp"></jsp:include>
	<center>
	<h2>Student Enrollment</h2>
	<form:form action="logout" method ="post">
		<input type="submit" value="Logout">
	</form:form>
	</center>
</body>
</html>