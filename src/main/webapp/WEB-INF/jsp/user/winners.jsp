<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Member Page</title>
</head>
<body>



 <h1 style=text-align:center;>Winner List</h1>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>FirstName</th>
   <th>LastName</th>
   <th>Address</th>
   <th>Username</th>
   
  </tr>
  <c:forEach items="${top3 }" var="member" >
   <tr>
    <td>${member.id }</td>
    <td>${member.firstname }</td>
    <td>${member.lastname }</td>
    <td>${member.address }</td>
    <td>${member.memusername}</td>
   
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>