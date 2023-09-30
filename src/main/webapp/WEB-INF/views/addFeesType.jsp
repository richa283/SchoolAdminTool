<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Fees Type</title>
</head>

<body>
<jsp:include page="verMenu.jsp"></jsp:include>
<!-- <center> --> 
<h2> Add Fees Type</h2>
 
	<form:form action="addfeestype" method="get" modelAttribute="feestype">
		<label>Fees Type : </label> <input type="text" name="feestype" placeholder="Type of Fees" />
		<br>
		<input type="submit" value="Add feestype">	 
	</form:form>
		
	<br><br>
	
	<table border="">
		<tr>
			<td>Fees Type</td>
			<td></td>
		</tr>
			
		<j:forEach var="feestype" items="${feestype}">
			<tr>
				<td>${feestype} </td>
				<td><a href="deletefeestype?feestype=${feestype}">Delete</a></td>
			</tr>
		</j:forEach>	
	</table>
<!-- </center> -->
</body>

</html>