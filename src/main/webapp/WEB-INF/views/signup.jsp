<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel = "icon" type = "image/png" href = "http://cdn.onlinewebfonts.com/svg/img_225861.png">

<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
      crossorigin="anonymous"
    />
   <style>
     <%@ include file="style.css"%>
	</style>

    <title>Image Management</title> 
</head>
<body>
	
	
	<body>
	<div class=" row m-5 p-5 box mx-auto center-block">
	 
	 <c:if test="${(error != null)}"> <p class="text-center text-danger"> <strong>${error}</strong> </p> </c:if> 
	<div class="border-bottom border-top border-primary row mb-3 mt-0"><strong class="mt-1 text">New User</strong></div>
      <div class="col-lg-12 ">
      	
        <form  action="signup"  class="form-data"> 
          <!--  -->
          <div class="row mb-3">
            <label for="colFormLabel " class="col-sm-3 text col-form-label"
              >Username:</label >
            <div class="col-sm-7  ">
              <input
                type="text"
                class="form-control form-input-name"
                id="colFormLabel"
                name="username"
                placeholder="username"
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
            
          </div>
          
          <div class="row mb-3">
            <label for="colFormLabel" class="col-sm-3 text col-form-label"
              >Email:</label
            >
            
            <div class="col-sm-7">
              <input
                type="email"
                class="form-control form-input-email"
                id="colFormLabel"
                name="email"
                placeholder="abc@xyz.com"
                required
              /> 
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
</body>

</body>
</html>