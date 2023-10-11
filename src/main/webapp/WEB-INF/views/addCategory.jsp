<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name = "viewport" content="width=device-width, initial-scale=1">
 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

<title>Add Category</title>

	<script type="text/javascript">
	function validateform(){
		var valid=false;
		var category=document.getElementById("category");
		
		if(category.value.length>3){
			document.getElementById("category").style="background-color: #FBE3E4; border-color: Red;"
				valid=false;
		}else{
			document.getElementById("category").style="background-color: white; border-color: black";
		}
		
		if(!valid){
			alert("Please input your correct category");
		}
				return valid;
	};
	</script>

</head>
<body>
	<jsp:include page="../../verMenu.jsp"></jsp:include>
	<!-- <center> -->
	<h2>Add Category Here</h2>
	
	<form:form action="addcategory" method="get" modelAttribute="category" onsubmit="false">
		<label>Category: </label><input type="text" name="category" id="category" placeholder="GEN/SC/ST/OBC" />
		<br>
		<input type="submit" value="Add category">
	</form:form>
	
	<br><br>
	
	<table class="table table-hover table-bordered">
	<tr>
		<td>Category</td>
		<td> </td>
	</tr>
	<j:forEach var="category" items="${category}">
	<tr>
		<td>${category}</td>
		<td><a href="deletecategory?category=${category}">Delete</a></td>
	</tr>
	</j:forEach>
	</table>
	
	<!-- </center> -->
</body>
</html>