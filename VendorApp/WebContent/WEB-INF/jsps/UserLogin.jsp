<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to User Login Page!!</h1>
<form action="loginUser" method="post">
<pre>
User Name : <input type="text" name="un"/> 
Password  : <input type="password" name="pwd"/>
<input type="submit" value="Login"/> 
</pre>
</form>
${msg}<br/>
No account yet?<a href="userReg">Register</a>Here
</body>
</html>