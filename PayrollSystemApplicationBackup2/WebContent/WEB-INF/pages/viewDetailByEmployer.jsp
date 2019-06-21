<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <title>All members</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>


	<jsp:include page="/WEB-INF/pages/employerPanel.jsp"></jsp:include>
	<c:choose>
		<c:when test="${!empty membersListData }">
		<div class="table-responsive">
			<table  class="table table-striped table-bordered" >
			    <thead class="thead-light ">
				<tr>
					<th>Member ID</th>
					<!-- <th>ENO</th> -->
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
					<th>Update</th>
					<th>Delete</th>
					<th>Generate Salary</th>
				</tr>
				</thead>
				<c:forEach var="dto" items="${membersListData }">
				<c:if test="${dto.ENo!=101}">
					
				<tr>
					<td>${dto.memberID }</td>
					<%-- <td>${dto.ENo }</td> --%>
					<td>${dto.name}</td>
					<td>${dto.FName}</td>
					<td>${dto.email}</td>
					<td>${dto.pwd}</td>
					<td>${dto.gender}</td>
					<td>${dto.mobileNo}</td>
					<td>${dto.panNo}</td>
					<td>${dto.adharNo}</td>
					<td>${dto.uan}</td>
					<td>${dto.doj}</td>
					<%-- <td>${dto.image}</td> --%>
					<td>${dto.desg}</td>
					<td>${dto.role}</td>
					<td>${dto.addrs}</td>
					<td>${dto.dob}</td>
					<td>${dto.qualification}</td>
					<td><a href="updateurl?id=${dto.ENo}" class="btn btn-info">Edit</a></td>
					<td><a href="deleteurl?id=${dto.ENo}" class="btn btn-info">Delete</a></td>
					<td><a href="generatesalaryurl?id=${dto.ENo}" class="btn btn-info">click</a></td>
				</tr>
				</c:if>
				</c:forEach>
			</table>
			</div>
		</c:when>
		<c:otherwise>
		<h1>no data</h1>
	</c:otherwise>
	</c:choose>
	


