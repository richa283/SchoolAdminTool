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
		<form:select path="classes">
			<form:option value="I"> I </form:option>
			<form:option value="II"> II </form:option>
			<form:option value="III"> III </form:option>
			<form:option value="IV"> IV </form:option>
			<form:option value="V"> V </form:option>
			<form:option value="VI"> VI </form:option>
			<form:option value="VII"> VII </form:option>
			<form:option value="VIII"> VIII </form:option>
			<form:option value="IX"> IX </form:option>
			<form:option value="X"> X </form:option>
			<form:option value="XI"> XI </form:option>
			<form:option value="XII"> XII </form:option>
		</form:select>
		<br>
		
		<label> Father-Name :</label><form:input path="father_name"/><br>
		<label> Mother-Name :</label><form:input path="mother_name"/><br>
		<label> Roll-no :</label><form:input path="roll_no"/><br>
		<label> Fees :</label><form:input path="fees"/><br>
		<label> Session :</label><form:input path="session"/><br>
		<label> Address :</label><form:input path="address"/><br>
		<label> Mobile :</label><form:input path="mobile"/><br>
		<input type="submit" value="Add Students">
		
	</form:form>
	<a href="studentsList"> Students List</a>
</div>
</body>
</html>