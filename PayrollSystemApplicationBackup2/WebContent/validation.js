function validate(frm) {
	// isValidate yes to indicatting client side validation has done
	frm.isValidate.value = "yes";
	// set style to error messages
	/*
	 * document.getElementById("nameErr").innerHTML="";
	 * document.getElementById("fNameErr").innerHTML="";
	 * document.getElementById("emailErr").innerHTML="";
	 * document.getElementById("pwdErr").innerHTML="";
	 * document.getElementById("genderErr").innerHTML="";
	 * document.getElementById("mNoErr").innerHTML="";
	 * document.getElementById("panNoErr").innerHTML="";
	 * document.getElementById("adharNoErr").innerHTML="";
	 * document.getElementById("uanNoErr").innerHTML="";
	 * document.getElementById("dojErr").innerHTML="";
	 * document.getElementById("dobErr").innerHTML="";
	 * document.getElementById("desgErr").innerHTML="";
	 * document.getElementById("roleErr").innerHTML="";
	 * document.getElementById("addrsErr").innerHTML="";
	 * document.getElementById("qlfyErr").innerHTML="";
	 * document.getElementById("imageErr").innerHTML="";
	 */
alert("avi gyo");
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

	// read form data and validate it
	if (frm.name.value == "") {
		document.getElementById("nameErr").innerHTML = " Name is required";
		frm.name.focus();
		alert("chal rha h bhai");
		return false;
	}// if
	if (frm.fName.value == "") {
		document.getElementById("fNameErr").innerHTML = "Father name is required";
		frm.name.focus();
		alert("chal rha h bhai");
		return false;
	}// if
	var tEmail = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if (tEmail.tst(frm.email.value) == false) {
		document.getElementById("emailErr").innerHTML = "Invalid email";
		frm.name.focus();
		alert("chal rha h bhai");
		return false;
	}// if

	var passw = /^[A-Za-z]\w{7,14}$/;
	if (frm.pwd.value.value.match(passw)) {
		document.getElementById("pwdErr").innerHTML = "Father name is required";
		frm.name.focus();
		alert("pwd bi chal rha h bhai");
		return false;
	}// if
	/*if (frm.fName.value == "") {
		document.getElementById("fNameErr").innerHTML = "Father name is required";
		frm.name.focus();
		return false;
	}// if
*/
}