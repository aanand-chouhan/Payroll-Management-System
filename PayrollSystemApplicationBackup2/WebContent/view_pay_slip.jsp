<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<head>
	  <title>Member Dashboard</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>
	
	<style>

 body{
 background-color: #f2f2f2;}
button, html input[type="button"], input[type="reset"], input[type="submit"] {
		margin-left: 13px;
	} 
	</style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>

	<c:when test="${!empty memberSalaryData }">
		<div class="table-responsive">
		<table class="table table-bordered table-hover">
		<thead class="thead-light">
			<tr>
				<th>CTC(COST TO COMPANY)</th>
				<th>House Rental Allowance</th>
				<th>Travel Allowance</th>
				<th>Conveyance allowance</th>
				<th>Special Allowance</th>
				<th>Medical Allowance</th>
				<th>Income Tax</th>
				<th>ProffesionalTax</th>
				<th>net salary</th>
				<th>month</th>
			</tr>

			<tr>

				<td>${memberSalaryData.ctc }</td>
				<td>${memberSalaryData.hra }</td>
				<td>${memberSalaryData.ta }</td>
				<td>${memberSalaryData.ca }</td>
				<td>${memberSalaryData.sa }</td>
				<td>${memberSalaryData.ma }</td>
				<td>${memberSalaryData.incomeTax }</td>
				<td>${memberSalaryData.proffesionalTax }</td>
				<td>${memberSalaryData.netSalary}</td>
				<td>${memberSalaryData.month}</td>
				
			</tr>
			</thead>
			</table>
			</div>
			</c:when>
			<c:otherwise>
		<h1>no data</h1>
	</c:otherwise>
			</c:choose>
