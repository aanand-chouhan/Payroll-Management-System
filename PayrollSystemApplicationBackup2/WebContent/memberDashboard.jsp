<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	 
 <%-- <c:if test="${isAccepted==yes}">
			<script type="text/javascript">
				alert(" Your request is accepted");
 			</script>
			
</c:if>
 <c:if test="${isAccepted==no}">
			<script type="text/javascript">
				alert(" Your request is not accepted");
 			</script>
			
</c:if>
<c:if test="${isAccepted==pending}">
			<script type="text/javascript">
				alert(" Your request is on pending");
 			</script>
			
</c:if> --%>
 <c:if test="${isUploaded!=null}">
			<script type="text/javascript">
				alert(" Your Document is uploaded succecfully");
 			</script>
			
</c:if>
<style>
.custom-select {
	margin-bottom: 60px;
	width: 200px;
}
.custom-file{
width: 230px;
margin-top: 16px;
padding-top: 16px;
margin-bottom: 54px;

}
#salary{
	float:left;
	width:250px;
}
 body{
 background-color: #f2f2f2;}
button, html input[type="button"], input[type="reset"], input[type="submit"] {
		margin-left: 13px;
	} 
</style>

<body>
<table class="table table-striped" >
<tr>
<td>
<div class="container mt-3" id="salary">
  <form action="viewPayslipurl" method="POST" onsubmit="return validate(this)" name="frm">
    <select name="month" class="custom-select mb-3">
      <option selected>Select Month</option>
      <option>1</option>
      <option>2</option>
      <option>3</option>
    </select><span id="monthErr"></span>
    <input type="hidden" name="email" value="${memberEmail }">
    <button type="submit" class="btn btn-primary" >View PaySlip</button>
  </form>
</div>
</td>
<td>
<div class="custom-file" class="container mt-3">
	<form action="uploaddocumenturl" method="POST" enctype="multipart/form-data" onsubmit="return validate(this)" name="frm">
    <input type="file" class="custom-file-input" id="customFile" name="document" onchange="checkextension()" required>
    <label class="custom-file-label" for="customFile">upload documents</label>
    <input type="hidden" name="email" value="${memberEmail }"><span id="udErr"></span>
    <button type="submit" class="btn btn-primary" >Upload</button>
    </form>
  </div>
  </td>
<%-- <form action="viewPayslipurl" method="POST" onsubmit="return validate(this)" name="frm">
<select name="month">
	<option>Select Month</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
</select><span id="monthErr"></span>
<input type="hidden" name="email" value="${memberEmail }">
<input type="submit" value="View PaySlip" >
</form><br><br>
 --%>
<td>
 <div class="container mt-3" id="pi">
 <form action="personalInfourl" method="POST" onsubmit="return validate(this)" name="frm">
 	<input type="hidden" name="email" value="${memberEmail }">
 	<button type="submit" class="btn btn-primary" >Personal Information</button>
 </form>
 </div>
 </td>
<%-- <form action="personalInfourl" method="POST" onsubmit="return validate(this)" name="frm">
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" value="Personal Information">
--%>
<td>
<div class="container mt-3" id="as">
 <form action="advanceSalaryRequest.jsp" method="post">
 	<input type="hidden" name="email" value="${memberEmail }">
 	<button type="submit" class="btn btn-primary" name="btn">Aplly for advance salary</button>
 </form>
 </div>

</td>
<%--
</form>
<form action="advanceSalaryRequest.jsp" method="post">
<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" name="btn" value="Aplly for advance salary">
</form>
--%>
<%-- <div class="container mt-3">
 <form action="uploaddocumenturl" method="POST" enctype="multipart/form-data">
 	<label class="control-label col-sm-2" for="gender">upload ducuments::</label>
 	<input type="file" name="document">
 	<input type="hidden" name="email" value="${memberEmail }">
 	<button type="submit" class="btn btn-primary" >Upload</button>
 </form>
 </div> --%>


<%--
<form action="uploaddocumenturl" method="POST" enctype="multipart/form-data">
	<input type="file" name="document">
	<!-- Enter document name::<input type="text" name ="docName"> -->
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" value="Upload">	
</form>
--%>
<td>
<div class="container mt-3" id="vd">
 <form action="viewdocumenturl" method="POST">
 	<input type="hidden" name="email" value="${memberEmail }">
 	<button type="submit" class="btn btn-primary" name="viewDoc">View Documents</button>
 </form>
 </div>
</td>
<%--<form action="viewdocumenturl" method="POST">
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" name="viewDoc" value="View Documents">
</form>


<a href="login.jsp">log out</a> --%>
<td>
<div class="container mt-3">
 <a href="login.jsp" class="btn btn-primary">log out</a>
 </div>
 </td>
</tr>
 </table>
<script type="text/javascript">
	function validate(frm){
		document.getElementById("monthErr").style = "color:red";
		document.getElementById("udErr").style = "color:red";
		if (frm.month.value == "Select Month") {
			//alert("in month");
 			document.getElementById("monthErr").innerHTML = " Please select Month";
 			frm.month.focus();
 			//alert("chal rha h bhai");
 			return false;
		}// if
		else{
			document.getElementById("monthErr").innerHTML = "";
		}
		
	}
	function checkextension() {
		  var file = document.querySelector("#customFile");
		  if ( /\.(jpe?g|png|gif|pdf|doc|docx)$/i.test(file.files[0].name) === false ) { alert("not an document!");}
		  }
	 
	  
</script>