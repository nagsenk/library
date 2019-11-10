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

<div >
<body>
 <spring:url value="/member/add" var="addURL" />
 

 <h1>Books List</h1>
 <table width="100%" border="1">
  <tr>
   <th>Title</th>
   <th>Author</th>
   <th>Price</th>
   <th>Category</th>
   
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${list }" var="list" >
   <tr>
    <td>${list.title }</td>
    <td>${list.author }</td>
    <td>${list.price}</td>
    <td>${list.category }</td>
   
    <c:if test= "${list.copies>0 }">
        <td>
     
     <a >Available</a>
    </td>
      </c:if>
      <c:if test="${list.copies==0}">
    <td>
     <spring:url value="/book/reserved/${member.memusername }/${list.title }" var="updateURL"/>
     <a href="${updateURL }">Reserve</a>
    </td>
		</c:if>
      
    
   
   </tr>    
  </c:forEach>
 </table>

</body>
</div>
</html>