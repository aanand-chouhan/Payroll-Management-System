<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="java.io.File" %> <%@ page import="org.apache.commons.io.FileUtils" %><%
	String fileName=(String)request.getAttribute("viewName");
    File pdfFile = new File("E:\\VidyayugAssignment\\PayrollSystemApplicationBackup2\\WebContent\\doc\\"+fileName); 
/* byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
response.setContentType("application/pdf");
response.getOutputStream().write(pdfByteArray);
response.getOutputStream().flush(); */
response.setHeader("Content-Type", getServletContext().getMimeType(pdfFile.getName()));
response.setHeader("Content-Length", String.valueOf(pdfFile.length()));
response.setHeader("Content-Disposition", "inline; filename=\"foo.pdf\"");
/* Files.copy(pdfFile.toPath(), response.getOutputStream()); */
%>