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

    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:if test="${isSalaryDetailInserted  }">
			<h1 style="color:red">Data saved successfully</h1>
			<%request.setAttribute("isSalaryDetailInserted",false);%>
		</c:if>
		
		<c:if test="${isSalaryUpdates  }">
			<h2 style="color:red">salary Updated successfully</h2>
			<%request.setAttribute("isSalaryDetailInserted",false);%>
		</c:if>
    	<c:choose>
		<c:when  test="${!empty salaryCalculation }">
		
		<form action="insertPaySlipurl" method="POST">
			<table  class="table table-bordered ">
			<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${salaryCalculation.memberID}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>CTC</td>
					<td><input type="text" name="ctc" value="${salaryCalculation.ctc}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>HRA</td>
					<td><input type="text" name="hra" value="${salaryCalculation.hra}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>CA</td>
					<td><input type="text" name="ca" value="${salaryCalculation.ca}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>TA</td>
					<td><input type="text" name="ta" value="${salaryCalculation.ta}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>SA</td>
					<td><input type="text" name="sa" value="${salaryCalculation.sa}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>MA</td>
					<td><input type="text" name="ma" value="${salaryCalculation.ma}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>PF</td>
					<td><input type="text" name="pf" value="${salaryCalculation.pf}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>BASIC SALARY</td>
					<td><input type="text" name="bs" value="${salaryCalculation.basicSal}" readonly="readonly" style="border:none"><td>
				</tr>
				
				<tr>
					<td>GRATUITY</td>
					<td><input type="text" name="gt" value="${salaryCalculation.gratuity}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>PROFESSIONAL TAX</td>
					<td><input type="text" name="pt" value="${salaryCalculation.proffesionalTax}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>INCOME TAX</td>
					<td><input type="text" name="it" value="${salaryCalculation.incomeTax} "readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>TAXABLE AMMOUNT</td>
					<td><input type="text" name="tamt" value="${salaryCalculation.taxablAmt}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>GROSS SALARY</td>
					<td><input type="text" name="gs" value="${salaryCalculation.grossSalary}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>MONTH</td>
					<td><input type="text" name="m" value="${salaryCalculation.month}" readonly="readonly" style="border:none"><td>
				</tr>
				<tr>
					<td>NET SALARY</td>
					<td><input type="text" name="ns" value="${salaryCalculation.netSalary}" readonly="readonly" style="border:none"><td>
				</tr>
				<!-- <tr><td><a href="calculatedurl">Re-enter CTC</a></td> -->
				<tr>
				<td><button type="submit" class="btn btn-info">Save</button></td></tr>
			</table>
			</form>
		</c:when>
		<c:otherwise>
		<h3><a href="viewDetailByEmployerurl" class="btn btn-info"> Go Back</a></h3>
	</c:otherwise>
	</c:choose>