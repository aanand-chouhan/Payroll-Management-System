<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>

<html lang="en">
<head>
  <title>login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
<style>
body{
background-color: #dbdbdb;}
	.form-group{
		width:60%;
	}
	.jumbotron{
		margin-top: 20px;
		margin-left: 270px;
		padding-top: 51px;
		padding-bottom: 66px;
		
		width: 600px;
	}
	/* .form-control{
		width:auto;
		
	} */
	button, html input[type="button"], input[type="reset"], input[type="submit"] {
		margin-left: 13px;
	}
	.container .jumbotron, .container-fluid .jumbotron {
	padding-left: 211px;}
	
</style>
</head>
<body background="E:\back.jpg">
	<h1 class="alert alert-dark" style="margin-left:550px; padding-bottom:10px">Payroll System</h1>
<div class="container">
 <div class="jumbotron">
  <form action="loginurl" method="Post" onsubmit="return validate(this)" name="frm">
    <div class="form-group">
      <label for="email">Email:</label>
     <input type="email" name="uName" class="form-control" id="email" placeholder="Enter email"><span id="uNameErr" ></span> 
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd"><span id="pwdErr"></span>
    </div>
    <!-- <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div> -->
    <div><a href="register.jsp" class="btn btn-info" role="button">Register here </a>
    	<button type="submit" class="btn btn-default">Submit</button>
    </div>
    
   
  </form>
   </div>
</div>

</body>
</html>
	