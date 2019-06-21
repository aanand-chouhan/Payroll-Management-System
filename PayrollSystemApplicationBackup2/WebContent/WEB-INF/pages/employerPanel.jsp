<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Employer Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<style>
	.custom-file{
width: 200px;
padding-top: 16px;
margin-bottom: 54px;
}
 body{
 background-color: #f2f2f2;}
button, html input[type="button"], input[type="reset"], input[type="submit"] {
		margin-left: 13px;
	} 
</style>
<table class="table table-striped">
	<tr>
	<td>
		<div class="custom-file" class="container mt-3">
			<form action="uploaddocumenturl" method="POST"
				enctype="multipart/form-data">
				<input type="file" name="document" class="custom-file-input" id="customFile">
				  <label class="custom-file-label" for="customFile">upload documents</label>
				<!-- Enter document name::<input type="text" name ="docName"> -->
				<input type="hidden" name="email" value="${memberEmail}"> 
				<button type="submit" class="btn btn-primary" >Upload</button>
			</form>
			</div>
		</td>
		<td><span id="register"><a href="register.jsp" class="btn btn-info" role="button">Add
					New Employee</a></span></td>

		<td><span id="view"> <a href="viewDetailByEmployerurl" class="btn btn-info" role="button">View
					employee</a></span></td>



		
		<td><a href="login.jsp" class="btn btn-info" role="button">log out</a></td>
	</tr>
</table>