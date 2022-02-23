<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %> 
 <form action="./adduser" method="post"> 
 User id: <input type="text" name="userId" required="required"><br><br> 
 User name: <input type="text" name="uname" required="required"><br><br> 
 Password: <input type="password" name="password" required="required"><br><br> 
 Email id: <input type="text" name="emailId" required="required"><br><br> 
 Mobile Number: <input type="text" name="mobile" required="required"><br><br> 

<input type="submit" value="Register"> 
 </form> 
</body>
</html>