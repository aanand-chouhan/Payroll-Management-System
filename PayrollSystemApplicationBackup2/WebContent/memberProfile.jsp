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
	
	input[type="text"]{
	 background-color: #f2f2f2;
	}
</style>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		<form action="ubdateDataIntoDBurl" method="post">
		
		<c:choose>
		
		<c:when test="${!empty memberData }">
		<div class="table-responsive">
			<table class="table table-bordered" >
			  <thead class="thead-light ">
				<tr>
					<!-- <th>ENO</th> -->
					<th>Member ID</th>
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
					<th>Image</th>
					
					
				</tr>
				<c:if test="${memberData.ENo!=101}">
					
				<tr>
					<%-- <td><input type="text" name="eNo" value="${memberData.ENo } " readonly="readonly" style="border:none"></td> --%>
					<td><input type="text" name="eNo" value="${memberData.memberID } " readonly="readonly" style="border:none"></td>
					<td><input type="text" name="name" value="${memberData.name}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="fName" value="${memberData.FName}" readonly="readonly" style="border:none"> </td>
					<td><input type="text" name="email" value="${memberData.email}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="pwd" value="${memberData.pwd}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="gender" value="${memberData.gender}" readonly="readonly" style="border:none"> </td>
					<td><input type="text" name="mobileNO" value="${memberData.mobileNo}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="panNO" value="${memberData.panNo}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="adharNo" value="${memberData.adharNo}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="uan" value="${memberData.uan}" style="border:none"></td>
					<td><input type="text" name="doj" value="${memberData.doj }" style="border:none"></td>
					<%-- <td>${memberData.image}</td> --%>
					<td><input type="text" name="desg" value="${memberData.desg}" style="border:none"></td>
					<td><input type="text" name="role" value="${memberData.role}" style="border:none"></td>
					<td><input type="text" name="addrs" value="${memberData.addrs}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="dob" value="${memberData.dob}" readonly="readonly" style="border:none"></td>
					<td><input type="text" name="qualification" value="${memberData.qualification}" readonly="readonly" style="border:none"></td>
					<td><img src="data:image/jpg;base64,${memberData.imageName}" alt="ni milli" width="70" height="60" class="rounded"/></td>
					
				</tr>
				
				</c:if>
				</thead>
			</table>
			
			<!-- <img src="E:\images\-587805280IMAGE.jpg" alt="ni milli" widht="100" height="100"> -->
		</div>
		<!-- <a href="memberDashboard.jsp" class="btn btn-primary"> Back</a> -->
		</c:when>
		<c:otherwise>
		<h1>no data</h1>
		<!-- <a href="memberDashboard.jsp" class="btn button-default"> Back</a> -->
	</c:otherwise>
	</c:choose>
		<!-- <img src="E:\acpic.jpg" alt="ni milli" width="100" height="100"> -->
		</form>