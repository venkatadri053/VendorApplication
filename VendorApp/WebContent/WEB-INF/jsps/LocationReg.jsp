<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Location Register!!</h1>
<form action="insertLoc" method="post" name="locForm" onsubmit="return validateLoc();">
<pre>

Name: <input type="text" name="locName"/><span id="locNameErr" class="error"></span>
Type: <input type="radio" name="locType" value="Urban">Urban<input type="radio" name="locType" value="Rural">Rural<span id="locTypeErr" class="error"></span>
<input type="submit" value="Register"/>
</pre>
</form>
${msg}
</body>
</html>



