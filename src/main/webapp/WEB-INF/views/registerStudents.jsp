<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Students Here</title>
</head>

<body>
<jsp:include page="../../verMenu.jsp"></jsp:include>
<div>
	<form:form action="addStudentsToDb" modelAttribute="student" method="get">
		
		<form:hidden path="id"/>
		
		<label>Name : </label><form:input path="name"/><br>
		<label>Class : </label>
		
	
	</form:form>
</div>
</body>
</html>