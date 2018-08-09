<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table  tr th{
	color: white;
	background-color: black;
}
</style>
</head>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Location Data Page!!</h1>
<a href="locExcelExport">Export to Excel</a>|<a href="locPdfExport">Export to Pdf</a>
<table border="1">
<tr>
 <th>Id</th><th>Name</th><th>Type</th>
</tr>
<c:forEach items="${locListObj}" var="loc">
<tr>
<td><c:out value="${loc.locId}"/></td>
<td><c:out value="${loc.locName}"/></td>
<td><c:out value="${loc.locType}"/></td>

<td><a href='deleteLoc?locId=<c:out value="${loc.locId}"/>'>Delete</a></td>
<td><a href='updateLoc?locId=<c:out value="${loc.locId}"/>'>Update</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>


