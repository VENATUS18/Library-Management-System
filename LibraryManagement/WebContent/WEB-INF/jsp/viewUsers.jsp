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
 <th>User Id</th> 
 <th>User Name</th> 
 <th>Password</th> 
 <th>Email Id</th>
 <th>Mobile</th>
 <th>User Type</th> 
 <th>Update</th> 
 <th>Remove</th> 
 </tr> 
 <c:forEach items="${al}" var="p"> 
 <tr> 
 <td>${p.userId}</td> 
 <td>${p.uname}</td> 
 <td>${p.password}</td>
 <td>${p.emailId}</td> 
 <td>${p.mobile}</td> 
 <td>${p.userType}</td> 
  <td><a href="./edituser?id=${p.userId}">Update User</a></td> 
  <td><a href="./removeuser?id=${p.userId}">Remove User</a></td> 
  </tr> 
  </c:forEach> 
 </table> 
 </div> 
</body>
</html>