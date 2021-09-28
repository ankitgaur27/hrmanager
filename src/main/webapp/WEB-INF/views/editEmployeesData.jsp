<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@page import="org.apache.commons.fileupload.*" %>
<%@page import="java.util.* , java.io.*" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>
<%@page import="java.io.File" %>
<%@page import="com.nagarro.hrmanager.data.Manager" %>
<%@page import= "org.apache.tomcat.util.codec.binary.Base64" %>
<%@page import= "java.text.DecimalFormat" %>    
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/png"
	href="https://image.shutterstock.com/image-vector/online-form-line-flat-vector-260nw-615709082.jpg">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous" />

	<style>
	  	<%@ include file="style.css"%>
	</style>
	
<title>Edit Employees Data</title>
</head>
<body>

	
	<nav class="navbar navbar-dark fixed-top bg-primary">
		<div class="justify-content-center container-fluid">
			<span class="text-white">Employee Form &#128209;</span>
		</div>
	</nav>
	
	<div class=" mx-auto body" >
		<c:if test="${(error != null)}">
		<div class="container-fluid text-center">
				<h7 class="text-danger">${error}  &#128546;</h7>
			</div>
		</c:if>
		
		<div class="">
			<div class="row text-center container-fluid">
				<div class="col-lg-10 text-center container-fluid mt-3 p-1">
					<h5 class="ms-3 ps-4"><strong>Emloyee's Form</strong></h5>
				</div>
				<hr>
			</div>
			<form method="POST" action="saveEdittedEmployeeData">
				<div class="p-2 row col-lg-12 is-valid">
					<div class="col-lg-7 mx-3">
						<label for="colFormLabel " class="text col-form-label">Employee Code</label>
					</div>
					<div class="col-lg-4">
						<input type="number" class="form-control form-input-name"
							id="colFormLabel" name="code"
							minlength="3" maxlength="3"
							value="${employeeId}"
							readonly="readonly"
							oninvalid="setCustomValidity('Please enter Code in numbers')"
							oninput="setCustomValidity('')" required />
					</div>
					<br> <br>
					<div class="col-lg-7 mx-3">
						<label for="colFormLabel " class="text col-form-label">Employee Name</label>
					</div>
					<div class="col-lg-4">
						<input type="text" class="form-control form-input-name"
							id="colFormLabel" name="name" placeholder="Employee's Name"
							value="${name}"
							pattern="[A-Za-z\s]+" minlength="1" maxlength="100"
							oninvalid="setCustomValidity('Please enter Name in Alphabets')"
							oninput="setCustomValidity('')" required />
					</div>

					<br> <br>
					<div class="col-lg-7 mx-3">
						<label for="colFormLabel" class="text col-form-label">Location</label>
					</div>
					<div class="col-lg-4">
						<input 
                        class="form-control"
                        id="colFormLabel" 
                        name="location"  
                        value="${location}" 
						maxlength="500"
                        placeholder="location Delhi/Mumbai.."
                        required></input>
					</div>

					<br> <br>
					<div class="col-lg-7 ms-3">
						<label for="colFormLabel " class="text col-form-label ">Email</label>
					</div>
					<div class="col-lg-4 mx-3">
						<input type="email" class="form-control form-input-name"
							id="colFormLabel" name="email"
							placeholder="abc@xyz.com"
							value="${email}"
							minlength="1" maxlength="100"
							oninvalid="setCustomValidity('')"
							oninput="setCustomValidity('')" required />
					</div>

					<br> <br>
					<div class="col-lg-7 ms-3">
						<label for="colFormLabel " class="text col-form-label ">Date of Birth</label>
					</div>
					<div class="col-lg-4 mx-3">
						<input type="date" class="form-control form-input-name"
							value="${dob}"
							min="1900-01-01" max="2021-01-01"
							id="colFormLabel" name="date" placeholder="DD-MM-YYYY"
							oninvalid="setCustomValidity('Please Enter Date (DD-MM-YYYY) ')"
							
							oninput="setCustomValidity('')" required />
					</div>

					<div class="row buttons text-center">
						<div class="col-lg-2 text-center ms-5 ps-5 mt-3">
							<input type="submit" class="btn btn-primary" value="Save">
						</div>
						<div class="col-lg-2 text-center mt-3">
							<form method="POST" action="employeeList" >
								<div class="row">
									<div> 
									  <a href="employeeList"> 
									  <%request.getSession().setAttribute("CANCEL","CANCEL"); %>
										<input type="submit" class="btn btn-danger ms-3" value="Cancel">
									  </a>
									 </div>
								</div>
							</form>
						</div>
					</div>
			</form>
		</div>
	</div>
	<nav class="navbar navbar-dark fixed-bottom bg-primary "
		style="text-align: center;">
		<div class="justify-content-center container-fluid">
			<img src="https://img.icons8.com/color/240/000000/facebook.png"
				width="30" height="24"> <img
				src="https://img.icons8.com/fluency/144/000000/instagram-new.png"
				width="30" height="24">
		</div>
	</nav>
</body>
</html>
