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
 <form action="./updatebook" method="post"> 
 Book ISBN:<input type="text" name="bookisbn" value="${book.bookIsbn }"><br><br> 
 Book Name: <input type="text" name="bookname" value="${book.bookName}"><br><br> 
 Author: <input type="text" name="author" value="${book.authorName}"><br><br> 
 Edition: <input type="text" name="edition" value="${book.edition}"><br><br> 
 Number of Copies: <input type="text" name="booknoc" value="${book.numberOfCopies}"><br><br> 
 Book description: <input type="text" name="bdes" value="${book.description}"><br><br> 
 <input type="submit" value="Update book"> 
 
 
 
 
 </form> 
</body>
</html>