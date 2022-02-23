<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.time.LocalDate" %>
    <%@ page import="java.util.Random" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%int rnumb = (int)((Math.random() * 9000000)+1000000);  %>
<body>
<%@ include file="header.jsp" %> 
 <form action="./insertissue" method="post"> 
 Book ISBN:<input type="number" name="bookisbn" value="${book.bookIsbn }"><br><br> 
 Book Name: <input type="text" name="bookname" value="${book.bookName}"><br><br>
 Issue Date:<input type="text" name="issuedate" value="<%=LocalDate.now()%>"><br><br>
 Return Date:<input type="text" name="returndate" value="<%=(LocalDate.now()).plusDays(30)%>"><br><br>
 Transaction Id:<input type="text" name="transid" value="<%=rnumb%>"><br><br>
 
 <%-- User Id:<select type="number" name="uid">
 
 <c:forEach items="${users}" var="p"> 
 <option value="${p.userId }">${p.userId }</option>
 </c:forEach>
 
 </select><br><br>--%>
 
 User Id:<input type="number" name="uid"> 
  
 <input type="submit" value="Issue Book" > 
 
 
 
 
 </form> 
</body>
</html>