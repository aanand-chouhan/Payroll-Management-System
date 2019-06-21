<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(frm){
		document.getElementById("uNameErr").style = "color:red";
		document.getElementById("pwdErr").style = "color:red";
		//alert("a gua");
		if (frm.uName.value == "") {
			document.getElementById("uNameErr").innerHTML = "Please enter email";
			frm.uName.focus();
			//alert(frm.pwd.value);
			return false;
		}// if
		var pwd = frm.pwd.value;
		//var pass = /(?=.*[0-9])(?=.[a-z])(?=.[A-Z]).{7,}/;
		if (pwd == "") {
			document.getElementById("pwdErr").innerHTML = "password Required";
			frm.pwd.focus();
			return false;
		}//if
	}
</script>
</head>
<body>
		<h2 style="text-align: center">Login page</h2>
	<form action="loginurl" method="Post" onsubmit="return validate(this)" name="frm">
		<table>
	
			<!-- <tr>
				<td>Select Company</td>
				<td><input type="text" name="company"></td>
			</tr>
			<tr>
				<td>Select Department</td>
				<td><input type="text" name="dept"></td>
			</tr> -->
			<tr>
				<td>User Name</td>
				<td><input type="text" name="uName"><span id="uNameErr"></span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd"><span id="pwdErr"></span></td>
			</tr>
			<tr>
				<td><a href="register.jsp">new Register here</a></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>

</body>
</html>