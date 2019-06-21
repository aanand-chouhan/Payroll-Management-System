<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	function validate(frm) {
		frm.isValidate.value = "yes";
		document.getElementById("nameErr").style = "color:red";
		document.getElementById("fNameErr").style = "color:red";
		document.getElementById("emailErr").style = "color:red";
		document.getElementById("pwdErr").style = "color:red";
		document.getElementById("genderErr").style = "color:red";
		document.getElementById("mNoErr").style = "color:red";
		document.getElementById("panNoErr").style = "color:red";
		document.getElementById("adharNoErr").style = "color:red";
		document.getElementById("uanNoErr").style = "color:red";
		document.getElementById("dojErr").style = "color:red";
		document.getElementById("dobErr").style = "color:red";
		document.getElementById("desgErr").style = "color:red";
		document.getElementById("roleErr").style = "color:red";
		document.getElementById("addrsErr").style = "color:red";
		document.getElementById("qlfyErr").style = "color:red";
		document.getElementById("imageErr").style = "color:red";
		if (frm.name.value == "") {
			document.getElementById("nameErr").innerHTML = " Name is required";
			frm.name.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		else {
			document.getElementById("nameErr").innerHTML = "";
		}
		if (frm.fName.value == "") {
			document.getElementById("fNameErr").innerHTML = "Father name is required";
			frm.fName.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		else {
			document.getElementById("fNameErr").innerHTML = "";
		}
		var tEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (tEmail.test(frm.email.value) == false) {
			document.getElementById("emailErr").innerHTML = "Please enter email";
			frm.email.focus();
			//alert(frm.pwd.value);
			return false;
		}// if
		else {
			document.getElementById("emailErr").innerHTML = "";
		}
		var pwd = frm.pwd.value;
		//var pass = /(?=.*[0-9])(?=.[a-z])(?=.[A-Z]).{7,}/;
		if (pwd == "") {
			document.getElementById("pwdErr").innerHTML = "password Required";
			frm.pwd.focus();
			return false;
		}//if
		else {
			document.getElementById("pwdErr").innerHTML = "";
		}
		/* else if (pwd.lenght <=6 || pwd.lenght >=15 ) {
			document.getElementById("pwdErr").innerHTML = "password must be between 6-15 ";
			frm.pwd.focus();
			return false;
		}//if */
		/* else if(pass.test(pwd)==false){
			document.getElementById("pwdErr").innerHTML = "password between 7 to 15 characters which contain at least one numeric digit and a special character";
			frm.pwd.focus();
			return false;
		}//if  */

		var gender = frm.gender.value;

		if ((frm.gender[0].checked == false)
				&& (frm.gender[1].checked == false)) {
			document.getElementById("genderErr").innerHTML = "choose your gender";
			return false;
		}//if
		else {
			document.getElementById("genderErr").innerHTML = "";
		}
		var mobile = frm.mobileNo.value;
		if (mobile == "") {
			document.getElementById("mNoErr").innerHTML = "Enter your mobile no";
			frm.mobileNo.focus();
			return false;
		}//if
		else if (isNaN(mobile)) {
			document.getElementById("mNoErr").innerHTML = "Enter 10 Digit only";
			frm.mobileNo.focus();
			return false;
		} else if (mobile.length != 10) {
			document.getElementById("mNoErr").innerHTML = "Must 10 digit no";
			frm.mobileNo.focus();
			return false;
		} else {
			document.getElementById("mNoErr").innerHTML = "";
		}
		var panNo = frm.panNo.value;
		var pt = /[A-Z]{5}[0-9]{4}[A-Z]{1}/;
		if (panNo == "") {
			document.getElementById("panNoErr").innerHTML = " PAN No is required";
			frm.panNo.focus();
			return false;
		}// if 
		else if ((panNo.length != 10)) {
			document.getElementById("panNoErr").innerHTML = "PAN No must be 10 digit ";
			frm.panNo.focus();
			return false;
		} else if (pt.test(panNo) == false) {
			document.getElementById("panNoErr").innerHTML = "It should be like AAAAA1234A";
			frm.panNo.focus();
			return false;
		} else {
			document.getElementById("panNoErr").innerHTML = "";
		}
		var adhar = frm.adharNo.value;
		if (adhar == "") {
			document.getElementById("adharNoErr").innerHTML = "Enter adhar no";
			frm.adharNo.focus();
			return false;
		} else if (isNaN(adhar)) {
			document.getElementById("adharNoErr").innerHTML = "Digits only adhar no";
			frm.adharNo.focus();
			return false;
		}
		/* else if( adhar.lenght !=12){
			document.getElementById("adharNoErr").innerHTML = "12 Digits required";
			frm.adharNo.focus();
			alert("adhar");
			return false;
			
		}//if */
		else if (adhar.length != 12) {
			document.getElementById("adharNoErr").innerHTML = "12 digit required";
			frm.adharNo.focus();
			return false;
		} else {
			document.getElementById("adharNoErr").innerHTML = "";
		}
		var uan = frm.uanNo.value;
		if (uan == "") {
			document.getElementById("uanNoErr").innerHTML = "Enter your UAN no";
			frm.uanNo.focus();
			return false;
		}//if
		else if (isNaN(uan)) {
			document.getElementById("uanNoErr").innerHTML = "Enter Digits only";
			frm.uanNo.focus();
			return false;
		} else if (uan.length != 10) {
			document.getElementById("uanNoErr").innerHTML = "10 digit required";
			frm.uanNo.focus();
			return false;
		} else {
			document.getElementById("uanNoErr").innerHTML = "";
		}
		//DATE VALIDATION
		var doj = frm.doj.value;
		/* var pattern = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/ ;
		   if (!(pattern.test(doj))) {
		   	//document.getElementById("dojErr").innerHTML = "please select Date ";
			//frm.dojNo.focus();
			alert("down doj");
		       return false;
		   }   */
		/*  var isValid= Date.parse(doj);
		 if (isNaN(isValidDate)) {
		 	  // when is not valid date logic

		 	  return false;
		 	} */

		/*  var minYear = 1902;
		 var maxYear = (new Date()).getFullYear();

		 re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
		 if(doj != '') {
		     if(regs = doj.match(re)) {
		       if(regs[1] < 1 || regs[1] > 12) {
		     	  document.getElementById("dojErr").innerHTML = "please select valid month "+regs[1];
		       } else if(regs[2] < 1 || regs[2] > 31) {
		     	  document.getElementById("dojErr").innerHTML = "please select valid date "+ regs[2];
		       } else if(regs[3] < minYear || regs[3] > maxYear) {
		     	  document.getElementById("dojErr").innerHTML = "please select valid year "+regs[3] + " - must be between " + minYear + " and " + maxYear;
		       }
		     } else {
		     	document.getElementById("dojErr").innerHTML = "please select valid date ";
		     }
		   } else if(!allowBlank) {
		 	  document.getElementById("dojErr").innerHTML = "please select valid date ";
		   } */
		if (frm.desg.value == "") {
			document.getElementById("desgErr").innerHTML = " Designation is required";
			frm.desg.focus();
			return false;
		}// if
		else {
			document.getElementById("desgErr").innerHTML = "";
		}
		if (frm.role.value == "") {
			document.getElementById("roleErr").innerHTML = " Role is required";
			frm.role.focus();
			return false;
		}// if
		else {
			document.getElementById("roleErr").innerHTML = "";
		}
		if (frm.addrs.value == "") {
			document.getElementById("addrsErr").innerHTML = " Address is required";
			frm.addrs.focus();
			return false;
		}// if
		else {
			document.getElementById("addrsErr").innerHTML = "";
		}
		if (frm.qlfy.value == "") {
			document.getElementById("qlfyErr").innerHTML = " Qualification is required";
			frm.qlfy.focus();
			return false;
		}// if
		else {
			document.getElementById("qlfyErr").innerHTML = "";
		}

		//IMAGE VALIDATION
	/* 	document.body.querySelector('input[type="file"]').addEventListener(
				'change', function() {
					if (this.files[0] && this.files[0].type.includes('image')) {
						console.log('file is an image');
					} else {
						console.log('file is not an image');
					}
				}); */
		

	}
	function checkextension() {
		  var file = document.querySelector("#image");
		  if ( /\.(jpe?g|png|gif)$/i.test(file.files[0].name) === false ) { alert("not an image!"); }
		}
</script>
</head>
<style>
#head {
	margin-left: 500px;
	color: red;
}

.form-horizontal .control-label {
	text-align: left;
}
.form-group {
    width: 450px;
}
.col-sm-2 {
    width: 58.667%;
}
body{
background-color: #dbdbdb;}
button, html input[type="button"], input[type="reset"], input[type="submit"] {
		margin-left: 13px;
	}
</style>
<body>

	<div class="container">
	 <div class="jumbotron">
		<!-- <h2 id="head">Registration page</h2> -->
		<form class="form-horizontal" action="registerurl" method="post"
			enctype="multipart/form-data" name="frm"
			onsubmit="return validate(this)">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name"
						placeholder="Enter name" name="name"><span id="nameErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="fNname">Father
					Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="fNname"
						placeholder="Enter father name" name="fName"><span
						id="fNameErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email"><span id="emailErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="pwd"><span id="pwdErr"></span>
				</div>
			</div>
	<div class="form-group">
			<div class="radio">
				<label class="control-label col-sm-2" for="gender"><b>Gender:</b></label>
				<div class="col-sm-10">
					<label><input type="radio" name="gender" value="male">Male</label>&nbsp;<label><input
						type="radio" name="gender" value="female">Female</label> <span
						id="genderErr"></span>
				</div>
			</div>
		</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="mobile">Mobile
					Number:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="mobile"
						placeholder="Enter Mobile" name="mobileNo"><span
						id="mNoErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="panNo">PAN
					Number:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="panNo"
						placeholder="Enter PanNo" name="panNo"><span id="panNoErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="adharNo">Adhar
					Number:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="adharNo"
						placeholder="Enter Adhar No" name="adharNo"><span
						id="adharNoErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="uanNo">UAN(Universal
					account number):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="uanNo"
						placeholder="Enter UAN No" name="uanNo"><span
						id="uanNoErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dojNo">Date of
					joining:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="dojNo" name="doj"
						required="required"><span id="dojErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="dobNo">Date of
					Birth:</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="dobNo" name="dob"
						required="required"><span id="dobErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="desgNo">Designation:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="desgNo"
						placeholder="Enter designation" name="desg"><span
						id="desgErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="roleNo">Role:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="roleNo"
						placeholder="Enter Role" name="role"><span id="roleErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="comment">Address:</label>
				<textarea class="form-control" rows="5" id="addrs" name="addrs"></textarea>
				<span id="addrsErr"></span>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="glfy">Highest
					Qualification:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="qlfy"
						placeholder="Enter qualification" name="qlfy"><span
						id="qlfyErr"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="roleNo">upload
					your photo:</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="image" name="image" onchange="checkextension()"><span
						id="imageErr"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="hidden" value="no" name="isValidate" />
					<a href="login.jsp" class="btn btn-info" role="button"> Log in</a>
					<button type="submit" class="btn btn-default">Register</button>
				</div>
			</div>
		</form>
		<noscript>
			<h1>please enable java script</h1>
		</noscript>
	</div>
</div>
</body>
</html>