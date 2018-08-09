<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Master.jsp"%>
	<h1>Vendor Edit Page!!</h1>
	<form action="updateVen" method="post">
		<pre>
Id   : <input type="text" name="venId" value="${venObj.venId}" readonly="readonly" />
Name : <input type="text" name="venName" value="${venObj.venName}" />
Eamil: <input type="text" name="venEmail" value="${venObj.venEmail}" />
Loc  : <select name="loc.locId" id="locInp">
		    <option value="-1">--select--</option>
		    <c:forEach items="${locListObj}" var="loc">
		  <c:choose>
		  <c:when test="${venObj.loc.locId eq loc.locId}">
		  <option value="${loc.locId}" selected="selected"><c:out value="${loc.locName}" /></option>
		  </c:when>
		  <c:otherwise>
		  <option value="${loc.locId}"><c:out value="${loc.locName}" /></option>
		  </c:otherwise>
		  </c:choose>
		  </c:forEach>
		  </select>
<input type="submit" value="Update" />
</pre>
	</form>
</body>
</html>