<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<style>
body, html {
  height: 100%;
  margin: 0;
  }
.bg
{
 background:url("http://www.edsocialmedia.com/wp-content/uploads/2012/01/Books-and-Computers-large1.jpg");
 width:100%;
 height:100vh;
 background-size:cover;
 background-position:center;
 background-attachment:fixed;
}
h1{color:#e3bd31;font-size:70px;text-align:center; background:brown;font-family:georgia;}/*main name parivartan prabhat*/

#main-wrapper {
width:650px;
height:720px;
margin: 5% auto;
background:white;
background-position:fixed;
padding: 5px 20px;
border-radius:20px;
border: 2px solid #2c3e50;
}
.avtar {
width:80px;
text-align:center;
}
.myform {
width:570px;
margin:auto;
background-attachment:fixed;
margin-left:0.8vw;
}
.inputvalues{ 
width:450px;
margin:3px auto;
padding:5px 15px;
}
#login_btn{
margin-top:10px;
background-color:#27ae60;
padding:5px;
color:white;
width:100%;
text-align:center;
font-size:18px;
font-weight:bold;
}
#register_btn{
margin-top:10px;
background-color:#3498db;
padding:5px;
color:white;
width:100%;
text-align:center;
font-size:20px;
font-weight:bold;
}

</style>
</head>
<body class="bg">
<h1>Parivartan Prabhat</h1>
<div id="main-wrapper">
<center><h2>Registration Form</h2> 
<img src="http://www.dialanywhere.com/images/assets/Login/avatar.png" class="avtar" /></center>
 <spring:url value="/authenticate/save" var="saveURL" />
 <form:form modelAttribute="authenticateForm" method="post" action="${saveURL }" >
<table>
<tr>
    <td>Username </td>
    <td>
     <form:input path="password"  class="inputvalues"/>
    </td>
   </tr>
   <tr>
    <td>Password </td>
    <td>
     <form:input path="password"  class="inputvalues"/>
    </td>
   </tr>
   <tr>
    <td>Retype Password </td>
    <td>
     <form:input path=""  class="inputvalues"/>
    </td>
   </tr>

	
  </table>
  
 </form:form>
 </div>
</body>
</html>