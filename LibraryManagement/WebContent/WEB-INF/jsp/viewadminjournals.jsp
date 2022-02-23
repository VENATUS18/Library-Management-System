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
 <th>Journal ISBN</th> 
 <th>Journal Name</th>  
 <th>J Author</th>
 <th>J Edition</th>
 <th>J Number of Copies</th> 
 <th>Journal Description</th> 
<th>Update</th> 
 <th>Remove</th> 
 </tr> 
 <c:forEach items="${al}" var="p"> 
 <tr> 
 <td>${p.jIsbn}</td> 
 <td>${p.jName}</td> 
 <td>${p.jauthorName}</td> 
 <td>${p.jedition}</td> 
 <td>${p.jnumberOfCopies }</td> 
 <td>${p.jdescription}</td> 
  <td><a href="./editjournal?id=${p.jIsbn}">Update Book</a></td> 
  <td><a href="./removejournal?id=${p.jIsbn}">Remove Book</a></td> 
   
  </tr> 
  </c:forEach> 
 </table> 
 </div> 
</body>
</html>