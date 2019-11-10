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
<a href="/welcome">logout</a>
 <spring:url value="/Book/add" var="addURL" />
 

 <h1>Book List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Title</th>
  
   
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listBooks }" var="user" >
   <tr>
   <c:if test="${user.availability=='available'}">
    <td>${user.bid }</td>
    <td>${user.title }</td>
   
    <td>
     <spring:url value="/book/issue/${user.title }/${user.bid }/${authenticate.username }" var="updateURL" />
     <a href="${updateURL }">Issue</a>
    </td>
   </c:if>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>