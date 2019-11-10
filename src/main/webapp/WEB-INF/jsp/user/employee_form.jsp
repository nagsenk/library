<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
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
<br>
<br>
<br>
<br>

<form class="myform"  action="/manager/employee/save" method="post"> 


 <table> 
 <tr><td><b></b></td>
	<td> <input  type="hidden" class="inputvalues"  name="empid" pattern="^[A-Z a-z" "]+" required placeholder="Enter Your Firstname"> </td></tr>
 
    
     <tr><td><b>Firstname:</b></td>
	<td> <input  type="text" class="inputvalues"  name="firstname" pattern="^[A-Z a-z" "]+" required placeholder="Enter Your Firstname"> </td></tr>

<tr><td><b>Lastname:</b></td>
	<td> <input  type="text" class="inputvalues"  name="lastname" pattern="^[A-Z a-z" "]+" required placeholder="Enter Your Lastname"> </td></tr>
<tr><td><b>Address:</b></td>
	<td> <input  type="text" class="inputvalues"  name="address" pattern="^[A-Z a-z" "]+" required placeholder="Enter Your address"> </td></tr>


	    <tr><td><b>Username:</b></td>
	<td> <input  type="text" class="inputvalues"  name="username" pattern="^[A-Z a-z" "]+"  placeholder="Enter Your address"> </td></tr>
	
     <tr><td><b>Password:</b></td>
	<td> <input type="password" class="inputvalues"   name="password" required pattern="^[A-Za-z0-9@]+" placeholder="Password"></td></tr>
	
     <tr><td><b>Retype Password:</b></td>
	<td> <input type="password" class="inputvalues"   name="rpassword" required pattern="^[A-Za-z0-9@]+" placeholder="Retype Password"></td></tr>
   <tr>
	<td colspan="2"> <input id="register_btn" type="submit" name="submit" value="Register"></td></tr>
	<tr>
	
  <table/>
  
 </form>
 </div>
</body>
</html>
