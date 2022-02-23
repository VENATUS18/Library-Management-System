<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminHeader.jsp" %> 
 

 <form action="addbookdetails"> 
 Book ISBN<input type="text" name="bisbn"><br><br> 
 Book name<input type="text" name="bname"><br><br> 
 Author<input type="text" name="author"><br><br>
 Edition<input type="text" name="edition"><br><br>  
 Number of Copies<input type="text" name="bnoc"><br><br>  
 Book description<input type="text" name="bdes"><br><br> 
 <input type="submit" value="Insert book"> 
 
 
 
 
 

 
 
 </form> 
</body>
</html>