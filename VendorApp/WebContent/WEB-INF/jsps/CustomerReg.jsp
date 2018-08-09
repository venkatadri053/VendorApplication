<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="insertCust" method="post">
<pre>

Name    : <input type="text" name="custName"/>
Email   : <input type="text" name="custEmail"/>
Type    : <select name="custType">
            <option value="seller">Seller</option>
            <option value="consumer">Consumer</option>
		</select>
Address : <textarea name="custAddr"></textarea>
<input type="submit" value="Insert"/>		
</pre>
</form>
${msg}
</body>
</html>



