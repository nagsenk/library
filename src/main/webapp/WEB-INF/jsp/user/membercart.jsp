<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User Page</title>
</head>
<body>
 
 <h1>Book List</h1>
 <table width="100%" border="1">
  <tr>
   <th>mID</th>
   <th>isbn</th>
  <th>Return Date</th>
   
  </tr>
  <c:forEach items="${list }" var="user" >
   <tr>
       <c:if test= "${user.mID == member.id}">
        <td>${user.mID }</td>
        <td>${user.isbn }</td>
        <td>${user.returndate}</td>
      </c:if>
    
   
  
    </c:forEach>
   </tr>    
 
 </table>
 
</body>
</html>