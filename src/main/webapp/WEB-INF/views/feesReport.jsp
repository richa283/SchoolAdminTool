<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Student Fees Report</title>
</head>

<body>
<jsp:include page="verMenu.jsp"></jsp:include>
	<!-- <center> -->
	<br> 
	<font color="green"> <h2> ${msg }</h2></font>
	
	<hr>
	<form action="feesReportGenerate" >
		<label> Start Date  : </label> <input type ="date" id ="startdate" name="startDate">
		<br> 		
		<label> End Date : </label> <input type ="date" id ="endDate" name="endDate">
	 	<br>
		<input type ="submit" value ="Generate Report">
	</form>
	<br> 
	<h2>Generated Report</h2>
	<br>

<!-- <center> --> 
	<b><label> Total Deposited Fees : </label> ${depositedFees}</b><br>
<!-- </center> -->

	<table class = "table table-hover table-bordered ">
	<tr>
		<th>Name</th>
		<th>Class</th>
		<th>Scholar Number</th>
		<th>Receipt No</th>
		<th>Amount</th>
		<th>Date</th>
				
		<th>Payment Mode </th>
		<th> Sender Bank </th>
		<th> Cheque No</th>
		<th> Cheque Date</th>
		<th> Account Number</th>
		<th> Receiver Bank</th>
		<th> Remark</th>			
	</tr>
			
	<j:forEach var="fees" items="${feesDto}">
	<tr>				
		<td>${stu.name}</td>
		<td>${stu.stuClass}</td>
		<td>${fees.scholarNumberOrName}</td>
		<td> ${fees.receiptNo}</td>
		<td>${fees.amount}</td>
		<td>${fees.date}</td>
			
		<td>${fees.paymentMode}</td>
		<td>${fees.senderBankName}</td>
		<td>${fees.chequeNo}</td>
		<td>${fees.chequeDate}</td>
		<td>${fees.accNo}</td>
		<td>${fees.recBank}</td>
		<td>${fees.remark}</td>			
	</tr>
	
	</j:forEach>
	</table>
	<br>
	<a  href="submitFees">Deposit Another Fees</a>
	<br><br><br><br>
<!-- </center> -->
</body>
</html>