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
 

 <form action="addjournaldetails"> 
 Journal ISBN<input type="text" name="jisbn"><br><br> 
 Journal name<input type="text" name="jname"><br><br> 
J Author<input type="text" name="jauthor"><br><br>
J  Edition<input type="text" name="jedition"><br><br>  
J Number of Copies<input type="text" name="jnoc"><br><br>  
 Journal description<input type="text" name="jdes"><br><br> 
 <input type="submit" value="Insert journal"> 
 
 
 
 
 

 
 
 </form> 
</body>
</html>