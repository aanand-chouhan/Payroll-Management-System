<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <head>
  <title>salary calculation</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function validation(frm){
		document.getElementById("ctcErr").style = "color:red";
		document.getElementById("monthErr").style = "color:red";
		if (frm.ctc.value == "") {
			document.getElementById("ctcErr").innerHTML = " Please enter CTC";
			frm.ctc.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		else if (isNaN(frm.ctc.value)) {
			document.getElementById("ctcErr").innerHTML = "enter no. only";
			frm.ctc.focus();
			return false;
		}
		
		if (frm.month.value == "Select Month") {
			//alert("in month");
			document.getElementById("monthErr").innerHTML = " Please select Month";
			frm.month.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
	}
</script>
	<form action="calculateurl" method="POST" name="frm" onsubmit="return validation(this)"> 
		<table >
			<tr>
				<td><label >Enter CTC</label ></td>
				<td><input type="text" name="ctc" class="form-control"><span id="ctcErr"></span></td>
			</tr>
			<tr >
				<td >Select Month</td>
				<td><select name="month" class="custom-select mb-3">
					<option>Select Month</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					
				</select><span id="monthErr"></span></td>
			</tr>
			<tr>
				
				<td colspan="2"> <input type="hidden" name="id" value="${ID}">
				<button type="submit" class="btn btn-info" style="margin-left:100px;">Enter</button></td>
			</tr>
		
		</table>
	</form>