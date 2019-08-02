<!DOCTYPE html>
<%@page import="com.techchefs.emp.beans.EmployeeInfoBean"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a href="/emp/profile"> <img alt="profile" src="profile.png"
					width="30px" height="30px"></a>
			</div>

			<div class="col-md-3 form-group pr-0">
				<form action="../validator/validate/employee/search">
					<input type="text" class="form-control" id="empId" name="empId"
						placeholder="search here...">
					<!-- <input type="hidden" name="url" value="./search"> -->
			</div>
			<div class="col-md-3 pl-0">
				<button type="submit" class="btn btn-primary">Submit</button>
				</form>

			</div>
			<div class="col-md-3">
				<a href="../login/logout">logout</a>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-12 text-center">
				<h5>Employee information</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h6>Personal Information</h6>

				${empBean.id} <br> ${empBean.name }<br>
				${empBean.accountNumber} <br> ${empBean.designation }<br>
				${empBean.phone} <br> ${empBean.age }<br>
				${empBean.accountNumber}<br>
			</div>
			<div class="col-md-4">
				<h5>Other Information</h5>

			</div>
			<div class="col-md-4">
				<h5>training Information</h5>

			</div>
		</div>
	</div>
</body>