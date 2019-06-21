<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
	  <title>Member Dashboard</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</head>

	<c:choose>
		<c:when test="${!empty isChecked}">

			<script type="text/javascript">
				alert(" Request has came for advance salary");
			</script>
			<table class=" table table-bordered table-striped">
				<c:forEach var="dto" items="${isChecked}">
					<tr>
						<td colspan="3">
								<c:out value="${dto.id}   is Requesting for advance salary Reasion is:: ${dto.reason } "></c:out>
						</td>
					</tr>
					<tr>
						<td><div><a href="appliedurl?applied=yes&is_checked=2&id=${dto.id}" class="btn btn-info">Accept</a></div></td>
						<td><div ><a href="appliedurl?applied=no&is_checked=2&id=${dto.id}" class="btn btn-info">Cancel</a></div></td>
						<td><div ><a href="appliedurl?applied=pending&is_checked=2&id=${dto.id}" class="btn btn-info">Pending</a></div></td>
					</tr>
				</c:forEach>
				
			</table>
		</c:when>
		<c:otherwise>
			<% request.setAttribute("memberEmail", request.getAttribute("memberEmail"));
			request.getRequestDispatcher("/WEB-INF/pages/employerPanel.jsp").forward(request,response); %>
		</c:otherwise>

	</c:choose>

