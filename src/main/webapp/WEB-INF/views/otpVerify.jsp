<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel = "icon" type = "image/png" href = "http://cdn.onlinewebfonts.com/svg/img_225861.png">
<title>OTP</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous" />
	<style>
     <%@ include file="style.css"%>
	</style>
</head>
<body>
<body>
	<div class=" mx-auto mt-5"
		style="border: 2px solid black; border-radius: 10px; background-color: white; width: 40%; height: 250px">
		<div class="">
			<div class="text-center mt-3 p-1">
				<h5>
					<strong>Create New Password</strong>
				</h5>
				<hr>
			</div>
			<form method="POST" action="otpVerify">

				<c:if test="${(error != null)}">
					<div class="px-5 mx-5"
						style="text-align:center; >
                		  <c:if test = "${(Color != null)}">
							background-color: ${Color}
						   </c:if> ;">
						<c:if test="${(error != null)}">
							${error}
						</c:if>
					</div>
				</c:if>



				<div class="p-2 row col-lg-12">
					<div class="col-lg-7">
						<label for="colFormLabel " class="text col-form-label">Enter
							OTP:</label>
					</div>
					<div class="col-lg-4">
						<input type="number" class="form-control form-input-name"
							id="colFormLabel" name="OTP" placeholder="XXXXX"
							onKeyPress="if(this.value.length>=5) return false;" required />
					</div>
				</div>

				<div class="text-center p-2 row col-lg-12">
					<div class="">
						<input type="submit" class="btn btn-primary" value="Submit">
					</div>
				</div>

			</form>
		</div>
	</div>

</body>
</body>
</html>