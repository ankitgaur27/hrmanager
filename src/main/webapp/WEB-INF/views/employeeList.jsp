<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <title>Employee Listings</title>

       <link rel = "icon" type = "image/png" href = "https://image.flaticon.com/icons/png/512/72/72728.png">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<style>
	     	<%@ include file="style.css"%>
		</style>

    </head>

    <body>
	<%
		System.out.println("!!");
		if(request.getSession().getAttribute("username").toString()==null){
			System.out.println("yash");
			response.sendRedirect("/home");
		}
	%>
        
		<nav class="navbar navbar-dark fixed-top bg-primary">
			<div class="justify-content-center container-fluid">
				<span class="text-white">&#x1F468;&#x1F3FB;&#x200D;&#x1F4BC; Employees List &#x1F468;&#x200D;&#x1F4BC;</span>
			</div>
		</nav>
        
        <div class="form-1-container p-4 mt-1">
	        <div class="container">
	            <div class="row">
	                
	            </div>
	            <div class="row">
                	<div class="col-lg-12  mt-4"> 
						<fieldset class="form-group border p-3">
							<legend class="w-auto px-2">Employee Listings</legend>
								<div class="row container-fluid justify-content-end">
									<div class=""><strong class="m-3">Welcome ${username} !</strong></div>
									
									<a href="logout" class="ms-3">
										<image class="image" src="https://www.pinclipart.com/picdir/middle/388-3882960_oxygen480-actions-dialog-close-clipart.png" width="30px" height="30px">
									</a>
								</div>
								<div class="row container-fluid justify-content-end">
									<form action="addEmployeeForm" method="post">
										<div class="p-2">
											<button class="btn btn-primary" type=submit>Upload Employee Details</button>
										</div>
									</form>
									<form action="download" method="post">
										<div class="p-2">
											<button class="btn btn-primary" type=submit>Download Employees List</button>
										</div>
									</form>
										
								</div>

								<div>
									<div>
										<div class = "p-2 container-fluid text-center scrollbar-primary" style="width:100%;  
										overflow-wrap: break-word; overflow-y: scroll;overflow-x: hidden; height: 350px;">
											<!--  -->
											<table class="table table-hover border">
												<thead class="thead-dark">
												  <tr>
													<th scope="col"> Employee &#127380;</th>
													<th scope="col"> Employee Name </th>
													<th scope="col"> Location &#127757; </th>
													<th scope="col"> Email &#128231;</th>
													<th scope="col"> Date of Birth &#128197;</th>
													<th scope="col"> Action &#128221; </th>
												  </tr>
												</thead>
												<tbody>
													<c:forEach items="${list}" var="employee" varStatus="loop">
														<tr>
															<th scope="row"><c:out value="${employee.employeeId}"/> </th>
															<td> <c:out value="${employee.employeeName}" /> </td>
															<td> <c:out value="${employee.location}" /></td>
															<td> <c:out value="${employee.employeeEmail}"/></td>
															<td> <c:out value="${employee.dateOfBirth}" /> </td>
															<td> 
																<form action="editEmployee">
																	<div class="">  
																		<div class="col-lg-12 text-center "> 
																			<input type="hidden" name ="code" value="${employee.employeeId}"></input>
																			<input class="btn border editbutton" type="submit"  value="&#128221; Edit" class = "edit"></input>
																		 </div>
																	</div>
																</form> 
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>  
								</div>
						</fieldset>	
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

</html>