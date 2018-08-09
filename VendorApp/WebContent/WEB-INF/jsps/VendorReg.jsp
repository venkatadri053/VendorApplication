<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Reg Page</title>
</head>
<body>
<%@include file="Master.jsp" %>
<h1>Vendor Reg Page!!</h1>
<form action="insertVen" method="post" name="venForm" onsubmit="return validateVenForm();" enctype="multipart/form-data">
<pre>
Name    : <input type="text" name="venName"/><span id="venNameErr" class="error"></span>
Email   : <input type="text" name="venEmail"/><span id="venEmailErr" class="error"></span>
Location: <select name="loc.locId" id="locInp">
		  <option value="-1">--select--</option>
		  <c:forEach items="${locListObj}" var="loc">
		  <option value="${loc.locId}"><c:out value="${loc.locName}"/></option>
		  </c:forEach>
		  </select><span id="locErr"></span>
File   : <input type="file" name="fileObj"/>		  
<input type="submit" value="Insert"/><input type="reset" value="Clear"/>
</pre> 
</form>
${msg}<br/>
</body>
</html>