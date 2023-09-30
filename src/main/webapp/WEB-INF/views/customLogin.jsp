<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Please Login Here</title>
</head>

<body>
<jsp:include page="verMenu.jsp"></jsp:include>
<!-- <center> -->
	<j:if test="${param.error!=null }">
		<i> Invalid ID or Password</i>
	</j:if><br>
	
	<j:if test="${param.logout!=null }">
		<i> You are Successfully logout ! Sign in Again</i>
	</j:if><br>
	
	<form:form>
		<label>Name : </label>
		<input type="text" name="username" />
		<br>
		<label>Password : </label>
		<input type="password" name="password" />
		<br>
		<input type="submit" value="Login">
	</form:form>
<!-- </center> -->
</body>

</html>