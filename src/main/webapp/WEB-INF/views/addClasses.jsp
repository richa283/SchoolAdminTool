<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name = "viewport" content = "width=device-width, initial-scale = 1">
    
       <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
      <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


<title>Add Classes</title>

<script> 

function validateform()
{
	
	var valid = true;
	
	var className = document.getElementById("className");
	var feesAmount = document.getElementById("feesAmount");


    if(className.value.length<=0 || !isNaN(className.value) || className.value.length>3 ) {   
    	document.getElementById("className").style="background-color: #FBE3E4; border-color: Red";
            valid = false;
        }else{
        	document.getElementById("className").style="background-color: white; border-color: black";
        }
    
    

    if(feesAmount.value.length<=0 || isNaN(feesAmount.value)  || feesAmount.value.length>10 ) {
    	document.getElementById("feesAmount").style="background-color: #FBE3E4; border-color: Red";
    valid = false;
	}else{
		document.getElementById("feesAmount").style="background-color: white; border-color: Black";
	}
    
    if(!valid){
    	alert("Please input Correct Details in Red Colored Fields");
    }
    
 return valid;   
}
</script>
</head>
<body>
<jsp:include page="../../verMenu.jsp"></jsp:include>
<center> 
<h2> Add Classes here</h2>
 
<form:form action="addClasses" method="get" modelAttribute="classes" onsubmit="return validateform()">

			<label>Class : </label> <input type="text" name="className" id="className" placeholder="Enter Class in Roman Number" />
			<Br>
			<label>Fees : </label> <input type="text" name="feesAmount" id="feesAmount" placeholder="Enter Fees Amount For Class" />
			<Br>

			<input type="submit" value="Add Class">
			 
		</form:form>
		
		<br> <br>
				<table class = "table table-hover table-bordered ">

			<tr>
				<td>Classes</td>
				<Td> Fees</Td>
				<Td>Action </Td>
			</tr>
			
			<j:forEach var="classes" items="${classes}">
				<tr>
					<td>${classes.classes}</td>
					<td>${classes.fees}</td>
					<td><a href="deleteclasses?classes=${classes.classes}">Delete</a></td>
				</tr>
			</j:forEach>
			
			</table>
</center>
</body>
</html>