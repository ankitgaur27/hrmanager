<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="java.util.* , java.io.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.nagarro.hrmanager.data.Manager"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.text.DecimalFormat"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/png"
	href="https://image.flaticon.com/icons/png/512/72/72728.png">
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
      crossorigin="anonymous"
    />
    
    <title>HR Manager</title>
    <style>
     <%@ include file="style.css"%>
	</style>

</head>
<body>
	<body>
	<%  
	  response.setHeader("Cache-Control","no-cache");
	  response.setHeader("Cache-Control","no-store");
	  response.setHeader("Pragma","no-cache");
	  response.setDateHeader ("Expires", 0);
	  if(session.getAttribute("username")==null){
		session.removeAttribute("error");
	  }
	%>
	<nav class="navbar navbar-dark fixed-top bg-primary">
		<div class="justify-content-center container-fluid">
			<span class="text-white">Welcome to Employee Managing Application</span>
		</div>
	</nav>
	<div class="row p-5 box mx-auto center-block">
	
	
	<c:if test="${(error != null)}"> <p class="text-center text-danger"> <strong>${error}</strong> </p> </c:if> 
	<div class="border-bottom border-top border-dark row mb-3 mt-0"><strong class="mt-1 text">Login</strong></div>
      <div class="col-lg-12">
      	
        <form method="post" action="employeeList" class=" form-data"> 
          <!--  -->
          <div class="row mb-3">
            <label for="colFormLabel " class="col-sm-3 text col-form-label"
              >Username:</label >
            <div class="col-sm-7">
              <input
                type="text"
                class="form-control form-input-name"
                id="colFormLabel"
                name="username"
                placeholder="username"
                pattern="[A-Za-z0-9]+"
                required
              /> 
 
            </div>
          </div>
          
          <!--  -->
          
          <div class="row mb-3">
            <label for="colFormLabel" class="col-sm-3 text col-form-label"
              >Password:</label
            >
            
            <div class="col-sm-7">
              <input
                type="password"
                class="form-control form-input-email"
                id="colFormLabel"
                name="password"
                placeholder="*********"
                required
              />
            </div>
            <div class="row mb-3 mt-3">
	            <a class= "col-lg-6" href="otpAuth">Reset Password</a>
	            <a class= "col-lg-6" href="signup">New User? Sign up</a>
	          </div>
          </div>
          <!--  -->
          <div>
          	<div class="text-center p-2 row col-lg-12" >
	           	<div class="">
	           		 <input type="submit" class="btn btn-primary" value="Submit">
	           	</div> 
	        </div>
          </div>
  
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
</body>
</html>