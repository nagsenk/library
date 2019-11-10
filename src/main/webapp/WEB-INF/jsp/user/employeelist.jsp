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
.bg{
background-image:url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuuZIYcRg6KqFOpx0FJWtdKISrRMJGyO7SP1oV4Pvu_EXYh5ks");
background-repeat:no-repeat;
width:100%;
 height:100vh;
 background-size:cover;
 background-position:center;
 background-attachment:fixed;
 colo:white

}
h1{color:white;font-size:70px;text-align:center;font-family:georgia;}
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

<div>
<body>
 <spring:url value="/manager/employee/add" var="addURL" />
 <a href="${addURL }">Add Employee</a>

 <h2>Employee List</h2>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>FirstName</th>
   <th>LastName</th>
  

   <th>username</th>
    <th>Address</th>
     <th>Join Date</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listEmployee }" var="member" >
   <tr>
    <td>${member.empid }</td>
    <td>${member.firstname }</td>
    <td>${member.lastname }</td>
  
    <td>${member.usname}</td>
    <td>${member.address }</td>
    <td>${member.joindate }</td>
    
  
    
    <td>
     <spring:url value="/manager/employee/delete/${member.empid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>

</body>
</div>
</html>