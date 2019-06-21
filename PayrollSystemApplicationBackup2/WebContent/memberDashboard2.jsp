<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


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
		
<form action="viewPayslipurl" method="POST" onsubmit="return validate(this)" name="frm">
<select name="month">
	<option>Select Month</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
</select><span id="monthErr"></span>
<input type="hidden" name="email" value="${memberEmail }">
<input type="submit" value="View PaySlip" >
</form><br><br>
<form action="personalInfourl" method="POST" onsubmit="return validate(this)" name="frm">
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" value="Personal Information">

</form>
<form action="advanceSalaryRequest.jsp" method="post">
<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" name="btn" value="Aplly for advance salary">
</form>

<form action="uploaddocumenturl" method="POST" enctype="multipart/form-data">
	<input type="file" name="document">
	<!-- Enter document name::<input type="text" name ="docName"> -->
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" value="Upload">	
</form>

<form action="viewdocumenturl" method="POST">
	<input type="hidden" name="email" value="${memberEmail }">
	<input type="submit" name="viewDoc" value="View Documents">
</form>


<a href="login.jsp">log out</a>
<script type="text/javascript">
	function validate(frm){
		document.getElementById("monthErr").style = "color:red";
		if (frm.month.value == "Select Month") {
			//alert("in month");
			document.getElementById("monthErr").innerHTML = " Please select Month";
			frm.month.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		
	}
	
</script>