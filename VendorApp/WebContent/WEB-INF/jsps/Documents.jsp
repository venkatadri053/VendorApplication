<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="uploadDoc" method="post" enctype="multipart/form-data">
<pre>
Document Id : <input type="text" name="docId"/> 
Document    : <input type="file" name="docDtls"/>
<input type="submit" value="Upload"/> 
</pre>
</form>
<table border="1">
<tr>
	<td>Id</td><td>Name</td><td>Download</td>
</tr>
<c:forEach items="${docList}" var="doc">
<tr>
<td><c:out value="${doc[0]}"/></td>
<td><c:out value="${doc[1]}"/></td>
<td><a href='download?fileId=<c:out value="${doc[0]}"/>'>Download</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>