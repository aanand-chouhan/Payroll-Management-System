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
    
   <%String email=request.getParameter("email"); request.setAttribute("memberEmail",email); %>
   
   <style>
   	textarea {
    margin: 12;px
    }
   </style>
    <form action="advanceSalaryurl" method="POST" name="frm" onsubmit="return validate(this)">
    	<div>
    		
    		<label for="advsal" class="alert alert-success" style="margin-top:20px; margin-left:10px;">Why you need the advance salary please specify here ::</label>
    		<textarea rows="3"  style="width:400px" name="reasionforAdvSal" class="form-control" ></textarea><span id="tErr"></span>
    	</div>
    	<input type="hidden" name="email" value="${memberEmail }">
    	<button type="submit" class="btn btn-info" style="margin-top:10px; margin-left:10px;">Apply</button>
    </form>
    
    
    
     <c:if test="${applied!=null }">
    	<script type="text/javascript">
		alert("successfully applied");
</script>
<!-- <a href="memberDashboard.jsp" class="btn btn-info" style="margin-left:10px;">back</a> -->
<%request.setAttribute("applied", null); %>
    </c:if>
    

    
    <script type="text/javascript">
	function validate(frm){
		document.getElementById("tErr").style = "color:red";
		if (frm.reasionforAdvSal.value == "") {
			//alert("in month");
			document.getElementById("tErr").innerHTML = " Please enter the reasion";
			frm.reasionforAdvSal.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		
	}
	
</script>