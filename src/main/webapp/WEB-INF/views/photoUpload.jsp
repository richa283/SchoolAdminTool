<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<!-- <center> -->
	<form action="processPhoto" method="post" enctype="multipart/form-data">
	<input type="file" name="pic"><br>
	<input type="submit" value="upload">
	</form>
	
	<hr><hr>
	<br>
	${aman}
	<img id="itemPreview" src="data:image/jpeg;base64,${pic}">
	<!-- </center> -->
</body>

</html>