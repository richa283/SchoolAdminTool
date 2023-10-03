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

<title>Student Fees Summary</title>

	 <script type="text/javascript">
            
	 function displayChequeDetails()
     {	
		 var paymentMode = document.getElementById("paymentMode");
		 var chequeDetails =  document.getElementById("displayChequeDetails");
		 
		 chequeDetails.style.display = paymentMode.value == "cheque" ? "block" : "none";
		
     }	 
	 
	 
	 function validateform()
            {
            	
            	var regex1 = /^[0-9]+$/ ;

            	var isValid1 = regex1.test(document.getElementById("amount").value);
                
            	var amount = document.getElementById("amount");
            	var date = document.getElementById("date");
            
            	
            	if (!isValid1){
            		alert("Please Enter amount in Numbers"); 
                	isValid=false;
            	};
            	
            	 if(date.value.length<=0) {   alert("Please provide valid Date!");
                 isValid = false;
             }
            	
                return isValid;
            };
        </script>
</head>

<body>
<jsp:include page="verMenu.jsp"></jsp:include>
<!-- <center> -->
<br> 
<font color="green"> <h2> ${msg }</h2></font>
<hr>
<form action="feesProcessing" onsubmit="return validateform()" >
<input type ="hidden" name="scholarNumber" value="${scholarNumber}">
<label> Payment Mode :</label> 
	<select name="paymentMode" id="paymentMode" onchange = "displayChequeDetails()"> 
	<option value="cash"> Cash</option>
	<option value="online"> Online</option>
	<option value="cheque"> Cheque</option>	
	</select>
		
		<div id="displayChequeDetails" style="display: none"> 
		<br> 
		<label>Bank Name </label> <input type="text" name="bankName" id="bankName" Placeholder="Bank Name"> 
		<label>Cheque No </label> <input type="text" name="chequeNo" id="chequeNo" Placeholder="Cheque Number"> <br> 
		<label>Cheque Date</label> <input type="date" name="chequeDate" id="chequeDate"> 
		<label>Account Number </label> <input type="text" name="accNo" id="accNo" Placeholder="Account Number"> <br>
		<label>Receiver Bank</label> <input type="text" name="recBank" id="recBank" Placeholder="Receiver Bank Name"> <br>
		<br>
		</div>
				<label> Amount : </label> <input type ="text"  id ="amount" name="amount">
				<label> Date of Transaction : </label> <input type ="date" id ="date" name="date">
		 <hr>
		<label> Remark</label> <input type="text" name="remark" Placeholder="Remark"><br>
		<input type ="submit" value ="submit Fees">
		</form>

		<h2>Fees Summary of Student</h2>
<br>
<!-- <center> --> 
<b><label> Total Fees : </label> ${stuDto.fees} </b> <br> 
<b><label> Total Deposited Fees : </label> ${remFees} </b> <br> 


<j:choose>
	<j:when test="${stuDto.fees > remFees}">
	<font color="red"> <b> <label> Total Remaining Fees : </label> ${stuDto.fees-remFees} </b> <br> </font>
	</j:when>
	
	<j:otherwise>
	<font color="green"> <b> <label> Advance Fees  : </label> ${stuDto.fees-remFees} </b> <br> </font>
  	</j:otherwise>
</j:choose>


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
				<th>Sender Bank </th>
				<th>Cheque No</th>
				<th>Cheque Date</th>
				<th>Account Number</th>
				<th>Receiver Bank</th>
				<th>Remark</th>
			</tr>
			
			<j:forEach var="fees" items="${feesDto}">
				<tr>
					<td>${stuDto.name}</td>
					<td>${stuDto.stuClass}</td>
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