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
<table border="1">
<tr>
	<th>Id</th><th>Name</th><th>Type</th>
</tr>
<c:forEach items="${custList}" var="cust">
<tr>
<td><c:out value="${cust.custId}"/></td>
<td><c:out value="${cust.custName}"/></td>
<td><c:out value="${cust.custType}"/></td>
<td><a href='showCustItem?custId=<c:out value="${cust.custId}"/>'>Show Items</a></td>
</tr>
</c:forEach>
</table>




</body>
</html>