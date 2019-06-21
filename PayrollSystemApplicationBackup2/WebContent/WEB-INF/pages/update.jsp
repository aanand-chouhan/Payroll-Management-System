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
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<form action="ubdateDataIntoDBurl" method="post">
		
		<c:choose>
		
		<c:when test="${!empty updateMember }">
		<div class="table-responsive">
			<table class="table table-bordered ">
			<thead class="thead-light">
				<tr>
					<th>ENO</th>
					<th>Name</th>
					<th>Father Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Gender</th>
					<th>Mobile Number</th>
					<th>Pan Number</th>
					<th>Adhar Number</th>
					<th>UAN Number</th>
					<th>Date of joing</th>
					<!-- <th>Photo</th> -->
					<th>Designation</th>
					<th>Role</th>
					<th>Address</th>
					<th>Date of birth</th>
					<th>Qualification</th>
					
					
				</tr>
				<c:if test="${updateMember.ENo!=101}">
					
				<tr>
					<td><input type="text" name="eNo" value="${updateMember.ENo }" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="name" value="${updateMember.name}" readonly="readonly" style="border:none;"> </td>
					<td><input type="text" name="fName" value="${updateMember.FName}" readonly="readonly" style="border:none;"> </td>
					<td><input type="text" name="email" value="${updateMember.email}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="pwd" value="${updateMember.pwd}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="gender" value="${updateMember.gender}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="mobileNO" value="${updateMember.mobileNo}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="panNO" value="${updateMember.panNo}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="adharNo" value="${updateMember.adharNo}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="uan" value="${updateMember.uan}" style="border:none;"></td>
					<td><input type="text" name="doj" value="${updateMember.doj }" style="border:none;"></td>
					<%-- <td>${updateMember.image}</td> --%>
					<td><input type="text" name="desg" value="${updateMember.desg}" style="border:none;"></td>
					<td><input type="text" name="role" value="${updateMember.role}" style="border:none;"></td>
					<td><input type="text" name="addrs" value="${updateMember.addrs}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="dob" value="${updateMember.dob}" readonly="readonly" style="border:none;"></td>
					<td><input type="text" name="qualification" value="${updateMember.qualification}" readonly="readonly" style="border:none;"></td>
					
					
				</tr>
				<tr>
					<td colspan="8"> <button type="submit" class="btn btn-info" >Update Record</button></td>
				</tr>
				</c:if>
				</thead>
			</table>
			</div>
		</c:when>
		<c:otherwise>
		<h1>no data</h1>
	</c:otherwise>
	</c:choose>
		
		</form>
		
		
		
		