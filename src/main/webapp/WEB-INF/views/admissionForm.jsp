<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name = "viewport" content = "width=device-width, initial-scale = 1">

    
     <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
      <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <style>
        @media (min-width: 1025px) {
  .h-custom {
    height: 100vh !important;
  }
}
.card-registration .select-input.form-control[readonly]:not([disabled]) {
  font-size: 1rem;
  line-height: 2.15;
  padding-left: .75em;
  padding-right: .75em;
}
.card-registration .select-arrow {
  top: 13px;
}

.gradient-custom-2 {
  /* fallback for old browsers */
  background: #a1c4fd;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to right, rgba(161, 196, 253, 1), rgba(194, 233, 251, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to right, rgba(161, 196, 253, 1), rgba(194, 233, 251, 1))
}

.bg-indigo {
  background-color: #4835d4;
}
@media (min-width: 992px) {
  .card-registration-2 .bg-indigo {
    border-top-right-radius: 15px;
    border-bottom-right-radius: 15px;
  }
}
@media (max-width: 991px) {
  .card-registration-2 .bg-indigo {
    border-bottom-left-radius: 15px;
    border-bottom-right-radius: 15px;
  }
}

    </style>
  

	 <script type="text/javascript">
            function validateform()
            {
            	var valid = true;
            	
                var name = document.getElementById("name");
                var religion = document.getElementById("religion");  
                var fName = document.getElementById("fName");
                var mName = document.getElementById("mName");
                var fOccupation = document.getElementById("fOccupation");
                var mOccupation = document.getElementById("mOccupation");
                var contact = document.getElementById("contact");
                var altContact = document.getElementById("altContact");                
                var scholarNumber = document.getElementById("scholarNumber");
                var lastSchoolStudied = document.getElementById("lastSchoolStudied");  
                var accNo = document.getElementById("accNo");
                var ifsc = document.getElementById("ifsc");
                var address = document.getElementById("address");
                var city = document.getElementById("city");
                var state = document.getElementById("state");
                var birthPlace = document.getElementById("birthPlace");
                var bankName = document.getElementById("bankName");          
                var zip = document.getElementById("zip");
                var samagraId = document.getElementById("samagraId");
                var aadhar = document.getElementById("aadhar");
                var dob = document.getElementById("dob");
                var admissionDate = document.getElementById("admissionDate");
                
                if(name.value.length<=0 || !isNaN(name.value) || name.value.length>20 ) {   
                	document.getElementById("name").style="background-color: #FBE3E4; border-color: Red";
                        valid = false;
                    }else{
                    	document.getElementById("name").style="background-color: white; border-color: black";
                    }
                
                if(scholarNumber.value.length<=0 || isNaN(scholarNumber.value) || scholarNumber.value.length>20) {   
                	document.getElementById("scholarNumber").style="background-color: #FBE3E4; border-color: Red";
                	valid = false;
                }else{
                	document.getElementById("scholarNumber").style="background-color: white; border-color: black";
                }

                    
                if(fName.value.length<=0 || fName.value.length>20 || !isNaN(fName.value) ) {
                	document.getElementById("fName").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("fName").style="background-color: white; border-color: Black";
            	}

                if(mName.value.length<=0 || mName.value.length>20 || !isNaN(mName.value) ) {
                	document.getElementById("mName").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("mName").style="background-color: white; border-color: Black";
            	}
                
                
                if(fOccupation.value.length<=0 || fOccupation.value.length>20 || !isNaN(fOccupation.value) ) {
                	document.getElementById("fOccupation").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("fOccupation").style="background-color: white; border-color: Black";
            	}
                
                if(mOccupation.value.length<=0 || mOccupation.value.length>20 || !isNaN(mOccupation.value) ) {
                	document.getElementById("mOccupation").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("mOccupation").style="background-color: white; border-color: Black";
            	}
                
                
                if(dob.value.length<=0 ) {
                	document.getElementById("dob").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("dob").style="background-color: white; border-color: Black";
            	}
                
                if(birthPlace.value.length<=0 || birthPlace.value.length>30 || !isNaN(birthPlace.value) ) {
                	document.getElementById("birthPlace").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("birthPlace").style="background-color: white; border-color: Black";
            	}

                if(religion.value.length<=0 || religion.value.length>20 || !isNaN(religion.value) ) {
                	document.getElementById("religion").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("religion").style="background-color: white; border-color: Black";
            	}

                if(admissionDate.value.length<=0 ) {
                	document.getElementById("admissionDate").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("admissionDate").style="background-color: white; border-color: Black";
            	}
    
                
                if(lastSchoolStudied.value.length<=0 || lastSchoolStudied.value.length>20 || !isNaN(lastSchoolStudied.value) ) {
                	document.getElementById("lastSchoolStudied").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("lastSchoolStudied").style="background-color: white; border-color: Black";
            	}

                if(contact.value.length<=0 || isNaN(contact.value) || contact.value.length<10 || contact.value.length>10 ) {
                	document.getElementById("contact").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("contact").style="background-color: white; border-color: Black";
            	}
                
                if(altContact.value.length<=0 || isNaN(altContact.value) || altContact.value.length<10 || altContact.value.length>15 ) {
                	document.getElementById("altContact").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("altContact").style="background-color: white; border-color: Black";
            	}
                    
                if(aadhar.value.length<=0 || isNaN(aadhar.value) || aadhar.value.length<10 || aadhar.value.length>20 ) {
                	document.getElementById("aadhar").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("aadhar").style="background-color: white; border-color: Black";
            	}
                
                if(samagraId.value.length<=0 || isNaN(samagraId.value) || samagraId.value.length>20 ) {
                	document.getElementById("samagraId").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("samagraId").style="background-color: white; border-color: Black";
            	}
                
                

                if(bankName.value.length<=0 || bankName.value.length>40 || !isNaN(bankName.value) ) {
                	document.getElementById("bankName").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("bankName").style="background-color: white; border-color: Black";
            	}

                
                if(accNo.value.length<=0 || isNaN(accNo.value) || accNo.value.length>20 || accNo.value.length<10 ) {
                	document.getElementById("accNo").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("accNo").style="background-color: white; border-color: Black";
            	}
	
                if(ifsc.value.length<=0 || ifsc.value.length>15  ) {
                	document.getElementById("ifsc").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("ifsc").style="background-color: white; border-color: Black";
            	}

             

                if(zip.value.length<=0 || isNaN(zip.value) || zip.value.length>10 ) {
                	document.getElementById("zip").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("zip").style="background-color: white; border-color: Black";
            	}

                
                
                if(address.value.length<=0  || address.value.length>1000 ) {
                	document.getElementById("address").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("address").style="background-color: white; border-color: Black";
            	}

                
                
                if(city.value.length<=0 || city.value.length>30 || !isNaN(city.value) ) {
                	document.getElementById("city").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("city").style="background-color: white; border-color: Black";
            	}

                if(state.value.length<=0 || state.value.length>40 || !isNaN(state.value) ) {
                	document.getElementById("state").style="background-color: #FBE3E4; border-color: Red";
                valid = false;
            	}else{
            		document.getElementById("state").style="background-color: white; border-color: Black";
            	}

               var allowedExtensions =  /(\.jpg|\.jpeg|\.png|\.gif)$/i; 
                
                var aadharPic =  document.getElementById('aadharPic');  
                var studentPic =  document.getElementById('studentPic');
                var samagraPic =  document.getElementById('samagraPic');
                var samagraPic =  document.getElementById('castPic');
                var tcPic =  document.getElementById('tcPic');
                var migrationPic =  document.getElementById('migrationPic');
                
                var aadharPath = aadharPic.value;
                var studentPath = studentPic.value;
                var samagraPath = samagraPic.value;
                var castPath = samagraPic.value;
                var tcPath = tcPic.value;
                var migrationPath = migrationPic.value;
 
    	
                if(aadharPath <=0 ){
                	document.getElementById("aadharPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(aadharPath)) {
                	document.getElementById("aadharPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                 }else{
                    const fi =  document.getElementById('aadharPic');  
                     if(fi.files.length > 0) {
                         
                     	for (const i = 0; i <1 ; i++) {
                     		
                     		const fsize = fi.files.item(i).size;
                             const file = Math.round((fsize / 1024));
                             // The size of the file.
                             if (file > 2048) { // Size in KB        	 
                                 alert("Aadhar Pic is too Big, Please select a file less than 2MB");
                                 valid = false;
                             } 	
                             break;
                     	}	
                     }  
                 } 
                
                if(studentPath <=0 ){
                	document.getElementById("studentPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(studentPath)) {
                	document.getElementById("studentPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                 }else{
                    const fi =  document.getElementById('studentPic');  
                     if(fi.files.length > 0) {
                         
                     	for (const i = 0; i <1 ; i++) {
                     		
                     		const fsize = fi.files.item(i).size;
                             const file = Math.round((fsize / 1024));
                             // The size of the file.
                             if (file > 2048) { // Size in KB        	 
                                 alert("Student Pic is too Big, Please select a file less than 2MB");
                                 valid = false;
                             } 	
                             break;
                     	}	
                     }  
                 } 
                
                
                
                if(samagraPath <=0 ){
                	document.getElementById("samagraPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(samagraPath)) {
                	document.getElementById("samagraPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                    } else{
                        const fi =  document.getElementById('samagraPic');  
                        if(fi.files.length > 0) {
                            
                        	for (const i = 0; i <1 ; i++) {
                        		
                        		const fsize = fi.files.item(i).size;
                                const file = Math.round((fsize / 1024));
                                // The size of the file.
                                if (file > 2048) { // Size in KB        	 
                                    alert("Samagra Pic is too Big, Please select a file less than 2MB");
                                    valid = false;
                                } 	
                                break;
                        	}	
                        }  
                    } 
                
                
                if(castPath <=0 ){
                	document.getElementById("castPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(castPath)) {
                	document.getElementById("castPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                            } else{
                                const fi =  document.getElementById('castPic');  
                                if(fi.files.length > 0) {
                                    
                                	for (const i = 0; i <1 ; i++) {
                                		
                                		const fsize = fi.files.item(i).size;
                                        const file = Math.round((fsize / 1024));
                                        // The size of the file.
                                        if (file > 2048) { // Size in KB        	 
                                            alert("Cast Pic is too Big, Please select a file less than 2MB");
                                            valid = false;
                                        } 	
                                        break;
                                	}	
                                }  
                            } 
                
                
                
                if(tcPath <=0 ){
                	document.getElementById("tcPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(tcPath)) {
                	document.getElementById("tcPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                            } else{
                                const fi =  document.getElementById('tcPic');  
                                if(fi.files.length > 0) {
                                    
                                	for (const i = 0; i <1 ; i++) {
                                		
                                		const fsize = fi.files.item(i).size;
                                        const file = Math.round((fsize / 1024));
                                        // The size of the file.
                                        if (file > 2048) { // Size in KB        	 
                                            alert("TC Pic is too Big, Please select a file less than 2MB");
                                            valid = false;
                                        } 	
                                        break;
                                	}	
                                }  
                            } 
 

                if(migrationPath <=0 ){
                	document.getElementById("migrationPic").style="background-color: Black; border-color: Black";
                //	alert("No file Selected");
                	valid=false;
                }else if (!allowedExtensions.exec(migrationPath)) {
                	document.getElementById("migrationPic").style="background-color: Black; border-color: Black";
//                                alert('Invalid file type or No File Selected');
                                fileInput.value = '';
                                valid = false;
                            } else{
                                const fi =  document.getElementById('migrationPic');  
                                if(fi.files.length > 0) {
                                    
                                	for (const i = 0; i <1 ; i++) {
                                		
                                		const fsize = fi.files.item(i).size;
                                        const file = Math.round((fsize / 1024));
                                        // The size of the file.
                                        if (file > 2048) { // Size in KB        	 
                                            alert("Migration Pic is too Big, Please select a file less than 2MB");
                                            valid = false;
                                        } 	
                                        break;
                                	}	
                                }  
                            } 
 
                
                
                
              if(!valid){
            	  alert("Please Enter Correct Details in Red Colored Fields");
              } 
                return valid;
            };           
            
            
          
            
            
        </script>


    <title>Registration Form</title>
</head>
<body>
<jsp:include page="../../verMenu.jsp"></jsp:include>
<form:form action="saveAdmissison" modelAttribute="admissionDto" method="post" enctype="multipart/form-data" onsubmit="return validateform()">
    
			<form:input type="hidden" path="id" />
    
    <section class="h-100 h-custom gradient-custom-2">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
              <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                <div class="card-body p-0">
                  <div class="row g-0">
                    <div class="col-lg-6">
                      <div class="p-5">
                        <h3 class="fw-normal mb-5" style="color: #4835d4;">Student Registration Form</h3>
      
                        <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                              <label class="form-label" for="form3Examplev2">Name</label>
                              <form:input type="text" id="name"  path="name" class="form-control form-control-lg" placeholder="Name"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Scholar Number</label>
	                            <form:input type="text" id="scholarNumber" path="scholarNumber" placeholder="Scholar Number" class="form-control form-control-lg"/>
                              </div>
        
                            </div>
                          </div>
      
                        <div class="row">
                          <div class="col-md-6 mb-4 pb-2">
      
                            <div class="form-outline">
                              <label class="form-label" for="form3Examplev2">Father's name</label>
                                <form:input type="text" id="fName" path="fName" placeholder="Father Name" class="form-control form-control-lg"/>
                            </div>
      
                          </div>
                          <div class="col-md-6 mb-4 pb-2">
      
                            <div class="form-outline">
                         	     <label class="form-label" for="form3Examplev3">Father Occupation</label>
                              <form:input type="text" id="fOccupation"  path="fOccupation" placeholder="Father Name" class="form-control form-control-lg"/>
                            </div>
      
                          </div>
                        </div>
      
                        <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Mother Name</label>
                              <form:input type="text" class="form-control form-control-lg" id="mName" path="mName" placeholder="Mother Name"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                               <label class="form-label" for="form3Examplev2">Mother Occupation</label>
                                <form:input type="text" class="form-control form-control-lg" id="mOccupation" path="mOccupation" placeholder="Father Name"/>
                              
                              </div>
        
                            </div>
                          </div>
      
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Class</label>

					<form:select path="stuClass">
					<j:forEach var="classesList" items="${classesList}">
					<option value="${classesList.classes}">${classesList.classes}</option>
					</j:forEach>
					</form:select>


<!--  for populating Class
					<form:select path="stuClass">
 					<option value="">${admissionDto.stuClass}</option>  
					</form:select>-->
	                            
                              </div>

        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Last Class Attended</label>
					 <form:select path="lastClassAttended">
					<j:forEach var="classesList" items="${classesList}">
					<option value="${classesList.classes}">${classesList.classes}</option>
					</j:forEach>
					</form:select>
			
                              </div>
        
                            </div>
                          </div>
      
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Branch</label>
           		 <form:select path="branch" >
						<option value="Gyan Jyoti Public School">Gyan Jyoti Public School</option>
						<option value="Gyan Jyoti International School">Gyan Jyoti International School</option>
					</form:select>
			                  </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Session</label>

			<div class="form-group col-md-6">
					<form:select path="session" >
						<j:forEach var="session" items="${session}">
					<option value="${session}">${session}</option>
					</j:forEach>
					</form:select>
				</div>


                              </div>
        
                            </div>
                          </div>

                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">DOB</label>
		<form:input type="date" id="dob" path="dob" class="form-control form-control-lg"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Place of Birth</label>
		<form:input type="text" class="form-control form-control-lg" id="birthPlace" path="birthPlace" placeholder="Place Of  Birth"/>
                              </div>
        
                            </div>
                          </div>
                          
                            <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                            <div class="form-outline">
							   <label class="form-label" for="form3Examplev2">Category</label><br>
							    <form:select path="category" >
								    <j:forEach var="listCategory" items="${listCategory}">
									<option value="${listCategory}">${listCategory}</option>
									</j:forEach>
								</form:select>
                             </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Religion</label>
                                <form:input type="text" class="form-control form-control-lg" id="religion" path="religion" placeholder="Religion"/>
                              </div>
        
                            </div>
                          </div>
                          
                          
                          
                          
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Admission Date</label>                                
                                <form:input type="date" id="admissionDate" path="admissionDate" class="form-control form-control-lg"/>
                              </div>
        
                            </div>
 
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Last School Studied</label>
                                <form:input type="text" class="form-control form-control-lg" id="lastSchoolStudied" path="lastSchoolStudied" placeholder="Last Attended School"/>
                              </div>
                       </div>
 
                         </div>
      
 <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Gender :</label>
                                
					<form:select path="gender">
					<option value="Male">Male</option>
					<option value="Female">FeMale</option>
					</form:select>                                       
                               </div>
        
                            </div>
 
                          
 
                         </div>
      
      
                      </div>
                    </div>
                    <div class="col-lg-6 bg-indigo text-white">
                      <div class="p-5">
                        <h3 class="fw-normal mb-5">Contact Details</h3>
      
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Contact</label>                                
                                <form:input type="text" class="form-control form-control-lg" id="contact" path="contact"  placeholder="Contact Number"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Alt-Contact</label>
                              <form:input type="text" class="form-control form-control-lg" id="altContact" path="altContact" placeholder="Contact Number"/>
                              </div>
        
                            </div>
                          </div>
                          
                          
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Aadhar Number</label>                                
                                <form:input type="text" class="form-control form-control-lg" id="aadhar" path="aadhar" placeholder="Aadhar Number"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Samagra Id</label>
                            <form:input type="text" class="form-control form-control-lg" id="samagraId" path="samagraId" placeholder="Samagra ID "/>
                              </div>
        
                            </div>
                          </div>
                          

                          
                            <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">Bank Name</label>                                
                                <form:input type="text" class="form-control form-control-lg" id="bankName" path="bankName" placeholder="Bank Names "/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev3">Account Number</label>
                           <form:input type="text" class="form-control form-control-lg" id="accNo" path="accNo" placeholder="Account No"/>
                              </div>
        
                            </div>
                          </div>
                          
                          
                          
                          
                          <div class="row">
                            <div class="col-md-6 mb-4 pb-2">
        
                              <div class="form-outline">
                                <label class="form-label" for="form3Examplev2">IFSC</label>                                
                              <form:input type="text" class="form-control form-control-lg" id="ifsc" path="ifsc" placeholder="IFSC Code"/>
                              </div>
        
                            </div>
                            <div class="col-md-6 mb-4 pb-2">
        
                             <div class="form-outline form-white">
                             <label class="form-label" for="form3Examplea4">Zip Code</label>
                              <form:input type="text" class="form-control form-control-lg" id="zip" path="zip" placeholder="Zip"/>
                            </div>
      
        
                            </div>
                          </div>
                          
                          
                          <div class="mb-4 pb-2">
                          <div class="form-outline form-white">
							<label class="form-label" for="form3Examplea3">Address </label>
                            <form:input type="text" path="address" id="address" class="form-control form-control-lg" />
                          </div>
                        </div>      
                        
      
                        <div class="row">
                          <div class="col-md-5 mb-4 pb-2">
      
                            <div class="form-outline form-white">
                              <label class="form-label" for="form3Examplea4">State</label>
                             <form:input id="state" path="state" class="form-control form-control-lg" placeholder="State"/>
                            </div>
      
                          </div>
                          <div class="col-md-7 mb-4 pb-2">
      
                            <div class="form-outline form-white">
                            <label class="form-label" for="form3Examplea5">City</label>
                              <form:input type="text" class="form-control form-control-lg" id="city" path="city" placeholder="city"/>
                            </div>
      
                          </div>
                        </div>
                        
                        
                                          <div class="row">
                          <div class="col-md-5 mb-4 pb-2">
      
                            <div class="form-outline form-white">
                              <label > Aadhar Photo</label>
                            <input type="file" id="aadharPic" name="aadharPic" />
                            </div>
      
                          </div>
                          <div class="col-md-7 mb-4 pb-2">
      
                            <div class="form-outline form-white">       
                            <label for="form:inputEmail4">Student Photo</label> <input type="file" id="studentPic" name="studentPic" />
                            </div>
      
                          </div>
                        </div>
                        
                        
                                                         <div class="row">
                          <div class="col-md-5 mb-4 pb-2">
      
                            <div class="form-outline form-white">
                              <label > Samagra Photo</label> <input type="file" id="samagraPic" name="samagraPic" />
                            </div>
      
                          </div>
                          <div class="col-md-7 mb-4 pb-2">
      
                            <div class="form-outline form-white">       
                           <label for="form:inputEmail4">Cast Certificate</label> <input type="file" id ="castPic" name="castPic" />
                            </div>
      
                          </div>
                        </div>
      		 
                        
                                                                     <div class="row">
                          <div class="col-md-5 mb-4 pb-2">
      
                            <div class="form-outline form-white">
                             <label for="form:inputEmail4">TC Photo</label> <input type="file" id="tcPic" name="tcPic" />
                            </div>
      
                          </div>
                          <div class="col-md-7 mb-4 pb-2">
      
                            <div class="form-outline form-white">       
                          <label >Migration Photo</label> <input type="file" id="migrationPic" name="migrationPic" />
                            </div>
      
                          </div>
                        </div>
                        
      
                        <input type="submit" class="btn btn-light btn-lg" data-mdb-ripple-color="dark" value="Admission Confirm">
      	<br> 
		      
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section> </form:form>
</body>
</html>
