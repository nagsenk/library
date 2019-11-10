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
<style>

h1{color:black;font-size:70px;text-align:center;font-family:georgia;}
.t1{background:#edbff0;height:150px;width:500px;float:center;display: inline-block; border:2px solid black;}
.t2{background:#d4eecf;height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
.t3{background:#eec4ba;height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
.t4{background:#bad3ee;height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
.t5{background:#f7f1b1;height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
.t6{background:pink;   height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
.t7{background:#c2f5b7;height:150px;width:500px;float:center;display: inline-block;border:2px solid black;}
input{height:50px;width:150px;}
</style>


</head>

<div class="bg">
<body>



 <h1>My Reserved Books</h1>
 <table width="100%" border="1">
  <tr>
   <th>MID</th>
   <th>title</th>
   <th>Date</th>
   
  </tr>
  <c:forEach items="${list }" var="member" >
   <tr>
    <td>${member.MID }</td>
    <td>${member.title}</td>
    <td>${member.reservedate }</td>
   
    
   </tr>    
  </c:forEach>
 </table>

</body>
</div>
</html>