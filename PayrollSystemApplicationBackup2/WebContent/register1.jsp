<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payroll System</title>
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
		if (frm.fName.value == "") {
			document.getElementById("fNameErr").innerHTML = "Father name is required";
			frm.fName.focus();
			//alert("chal rha h bhai");
			return false;
		}// if
		var tEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (tEmail.test(frm.email.value) == false) {
			document.getElementById("emailErr").innerHTML = "Please enter email";
			frm.email.focus();
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
		
		
		var gender=frm.gender.value;

		if ((frm.gender[0].checked == false) && (frm.gender[1].checked == false)) {
			document.getElementById("genderErr").innerHTML = "choose your gender";
			return false;
		}//if
		var mobile = frm.mobileNo.value;
		 if(mobile=="" ){
			document.getElementById("mNoErr").innerHTML = "Enter your mobile no";
			frm.mobileNo.focus();
			return false;
		}//if
		else if (isNaN(mobile)) {
			document.getElementById("mNoErr").innerHTML = "Enter 10 Digit only";
			frm.mobileNo.focus();
			return false;
		}
		else if (mobile.length !=10) {
			document.getElementById("mNoErr").innerHTML = "Must 10 digit no";
			frm.mobileNo.focus();
			return false;
		}
		var panNo=frm.panNo.value;
		var pt=/[A-Z]{5}[0-9]{4}[A-Z]{1}/;
		 if ( panNo== "") {
				document.getElementById("panNoErr").innerHTML = " PAN No is required";
				frm.panNo.focus();
				return false;
			}// if 
			else if((panNo.length !=10)){
				document.getElementById("panNoErr").innerHTML = "PAN No must be 10 digit ";
				frm.panNo.focus();
				return false;
			}
			else if(pt.test(panNo)==false){
				document.getElementById("panNoErr").innerHTML = "It should be like AAAAA1234A";
				frm.panNo.focus();
				return false;
			}
			var adhar=frm.adharNo.value;
			if(adhar==""){
				document.getElementById("adharNoErr").innerHTML = "Enter adhar no";
				frm.adharNo.focus();
				return false;
			}
			else if(isNaN(adhar)){
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
			else if (adhar.length !=12) {
				document.getElementById("adharNoErr").innerHTML = "12 digit required";
				frm.adharNo.focus();
				return false;
			}
			var uan = frm.uanNo.value;
			 if(uan=="" ){
				document.getElementById("uanNoErr").innerHTML = "Enter your UAN no";
				frm.uanNo.focus();
				return false;
			}//if
			else if (isNaN(uan)) {
				document.getElementById("uanNoErr").innerHTML = "Enter Digits only";
				frm.uanNo.focus();
				return false;
			}
			else if (uan.length !=10) {
				document.getElementById("uanNoErr").innerHTML = "10 digit required";
				frm.uanNo.focus();
				return false;
			}
		 //DATE VALIDATION
			var doj=frm.doj.value;
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
					if (frm.role.value == "") {
						document.getElementById("roleErr").innerHTML = " Role is required";
						frm.role.focus();
						return false;
					}// if
					if (frm.addrs.value == "") {
						document.getElementById("addrsErr").innerHTML = " Address is required";
						frm.addrs.focus();
						return false;
					}// if
					if (frm.qlfy.value == "") {
						document.getElementById("qlfyErr").innerHTML = " Qualification is required";
						frm.qlfy.focus();
						return false;
					}// if
					
					//IMAGE VALIDATION
					document.body.querySelector('input[type="file"]')
			        .addEventListener('change', function () {
			            if (this.files[0] && this.files[0].type.includes('image')) {
			                console.log('file is an image');
			            } else {
			                console.log('file is not an image');
			            }
			        });

	}
</script>
</head>
<body>



	<h2 style="text-align: center">Registration page</h2>
	<form action="registerurl" method="post" enctype="multipart/form-data"
		name="frm" onsubmit="return validate(this)">
		<table>

			<tr height="20px">
				<td>Name</td>
				<td><input type="text" name="name"><span id="nameErr"></span></td>
			</tr>
			<tr height="20px">
				<td>Father Name</td>
				<td><input type="text" name="fName"><span id="fNameErr"></span></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="email" name="email"><span
					id="emailErr"></span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pwd"><span id="pwdErr"></span></td>
			</tr>
			<tr>
				<td>gender</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female <span id="genderErr"></span></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobileNo"><span id="mNoErr"></span></td>
			</tr>
			<tr>
				<td>PAN Number</td>
				<td><input type="text" name="panNo"><span id="panNoErr"></span></td>
			</tr>
			<tr>
				<td>Adhar Number</td>
				<td><input type="text" name="adharNo"><span id="adharNoErr"></span></td>
			</tr>
			<tr>
				<td>UAN(Universal account number)</td>
				<td><input type="text" name="uanNo"><span id="uanNoErr"></span></td>
			</tr>
			<tr>
				<td>Date of joining</td>
				<td><input type="date" name="doj" required="required"><span id="dojErr"></span></td>
			</tr>
			<tr>
				<td>Date of birth</td>
				<td><input type="date" name="dob" required="required"><span id="dobErr"></span></td>
			</tr>

			<tr>
				<td>Designation</td>
				<td><input type="text" name="desg"><span id="desgErr"></span></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="role"><span id="roleErr"></span></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea rows="3" cols="15" name="addrs"></textarea><span
					id="addrsErr"></span></td>
			</tr>

			<tr>
				<td>Highest Qualification</td>
				<td><input type="text" name="qlfy"><span id="qlfyErr"></span></td>
			</tr>
			<tr>
				<td>upload your photo</td>
				<td><input type="file" name="image"><span id="imageErr"></span></td>
			</tr>
			<tr>

				<td colspan="2"><input type="hidden" value="no"
					name="isValidate" /> <input type="submit" value="Register"></td>
			</tr>



		</table>
	</form>
	<noscript>
		<h1>please enable javas</h1>
	</noscript>
</body>

</html>





<!--

//-->

