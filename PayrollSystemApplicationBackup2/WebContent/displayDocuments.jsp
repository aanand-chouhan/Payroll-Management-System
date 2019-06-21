
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
		
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<form action="ubdateDataIntoDBurl" method="post">
		
		
<%-- 	<%	
	response.setHeader("Content-Type", "application/pdf");
	response.setHeader("Content-Length", String.valueOf("${memberDocList.imageName}"));
    response.setHeader("Content-Disposition", "inline;filename=Saba_PhBill.pdf");
     %>
 --%>		<c:choose>
		
		<c:when test="${!empty memberDocList }">
		<%-- <%byte[] b= java.io.bind.DatatypeConverter.parseBase64Binary(file);
		String fileName=new java.util.Random().nextInt()+"IMAGE";
		FileOutputStream fos=new FileOutputStream("E:\\VidyayugAssignment\\PayrollSystemApplicationBackup2\\WebContent\\doc\\"+fileName);
		fos.write(b);
		fos.flush();
		fos.close(); %> --%>
			<table border="1" >
				<tr>
					<th>ID</th>
					<th>Document Name</th>
					<th>Document</th>
				</tr>
				<c:forEach var="dto" items="${memberDocList}">	
				<tr>
				<%-- <c:out value="${dto.ENo}"></c:out> --%>
					<td><input type="text" readonly="readonly" value="${dto.ENo}"></td>
					
					<td><input type="text" readonly="readonly" value="${dto.docName}"></td>
					<td><a href="viewDocurl?viewName=${fileName}">click here</a></td>
				</tr>
				</c:forEach>
				
			</table>
			<!-- <img src="E:\images\-587805280IMAGE.jpg" alt="ni milli" widht="100" height="100"> -->
		</c:when>
		<c:otherwise>
		<h1>no data</h1>
	</c:otherwise>
	</c:choose>
		<!-- <img src="E:\acpic.jpg" alt="ni milli" width="100" height="100"> -->
		</form>