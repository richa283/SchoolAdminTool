<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	
	<title>Session</title>
	
		<script type="text/javascript">
			function validateform()
			{
				var valid = true;
				
				var sessionStart = document.getElementById("sessionStart");
				var sessionEnd = document.getElementById("sessionEnd");
				
				if(sessionStart.value.length<=0){
					document.getElementById("sessionStart").style="background-color: #FBE3E4; border-color: Red";
				valid = false;					
				}else{
					document.getElementById("sessionStart").style="background-color: white; border-color: Black";
				}
				
				if(sessionEnd.value.lengh<=0){
					document.getElementById("sessionEnd").style="background-color: #FBE3E4; border: Red";
				valid= false;
				}else{
					document.getElementById("sessionEnd").style="background-color: white; border-color: Black";
				}
				
			if(!valid){
				alert("Please Input Correct Session Dates");
			}
				return valid;
			};
		</script>
</head>

<body>
	<jsp:include page="verMenu.jsp"></jsp:include>
	<!-- <center> -->
	<h2>Add Session Here</h2>
	
	<form:form action="addsession" method="get" modelAttribute="session" onsubmit="return validateform()">
		<label>Session Start: </label><input type="date" name="sessionStart" id="sessionStart" placeholder="dd/mm/yyyy"/>
		<br>
		<label>Session End: </label><input type="date" name="sessionEnd" id="sessionEnd" placeholder="dd/mm/yyyy"/>
		<br>
		<input type="submit" value="Add Session">
	</form:form>
	
	<br><br>
	<table class="table table-hover table-bordered">
	<tr>
	<td>Session</td>
	<td> </td>
	</tr>
	
	<j:forEach var="session" items="${session}">
	<tr>
	<td>${session}</td>
	<td><a href="deletesession?session=${session}">Delete</a></td>
	</tr>
	</j:forEach>
	
	</table>
	<!-- </center> -->
</body>
</html>