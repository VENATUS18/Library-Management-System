<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminHeader.jsp" %> 
 <div> 
 <table> 
 <tr> 
 <th>Book ISBN</th> 
 <th>Book Name</th>  
 <th>Author</th>
 <th>Edition</th>
 <th>Number of Copies</th> 
 <th>Book Description</th> 
 <th>Update</th> 
 <th>Remove</th> 
 <th>Issue</th> 
 </tr> 
 <c:forEach items="${al}" var="p"> 
 <tr> 
 <td>${p.bookIsbn}</td> 
 <td>${p.bookName}</td> 
 <td>${p.authorName}</td> 
 <td>${p.edition}</td> 
 <td>${p.numberOfCopies }</td> 
 <td>${p.description}</td> 
  <td><a href="./editbook?id=${p.bookIsbn}">Update Book</a></td> 
  <td><a href="./removebook?id=${p.bookIsbn}">Remove Book</a></td> 
  <td><a href="./issue?id=${p.bookIsbn}">Issue Book</a></td> 
   
  </tr> 
  </c:forEach> 
 </table> 
 </div> 
</body>
</html>