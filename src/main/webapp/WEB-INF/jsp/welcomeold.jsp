<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
   
  <style>
 
body{
background-image:url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQB2vPXfCovdv_uLTQUzene0uRHCE89-lmR1Gy1X4A2vGfCYdIt");
background-position:center;
background-repeat:no-repeat;
background-size:cover;
}
.header h1{margin-top:70px;color:#c6dde3;font-size:70px;text-align:center;font-family:georgia;}/*main name parivartan prabhat*/
.quote h2{margin-top:40px;color:white;font-size:40px;text-align:center;font-family:georgia;}/*quote*/
 
.aboutus {/*welcome box*/
width:600px;
height:570px;
margin: 6% auto;
background:#e8cbed;
padding: 5px 20px;
border-radius:20px;
border: 2px solid #2c3e50;
background-attachment:fixed;
text-align:center;
font-family:URW Chancery L, cursive ;
font-size:30px;
}
.login{text-align:center;}/*buttons division*/

input{height:60px;
width:170px;
font-size:18px;
color:white;
}
#user{background:crimson;}
#employee{background:green;}
#manager{background:blue;}
a{text-decoration:none;color:white;} 
.explore{text-align:center;background:powder-blue;}
.explore h1{color:white;}

#footer{
width:100%;
height:100px;
background:#342f2f;
clear:both;
margin-top:50px;
}
</style>
</head>
<body>
<div class="container">
<div class="header">
<h1>Parivartan Prabhat</h1>
</div>
<div class="quote">
<h2>A place Vibrating with ideas!!         Keep Calm and Read On</h2>
</div>
<div class="aboutus"><!welcome container>
<h1>Welcome</h1>
This Library is dedicated to the assembly, preservation, and organization of resources from all types of media in a learning and recreational center serving all residents and visitors. It offers each patron an opportunity to seek knowledge, pleasure, personal betterment, and quiet reflection in surroundings dedicated to the pursuit of enlightenment.
We are here so you, our patrons, can explore, learn and get help with all your information needs.
</div>
<div class="explore">
<h1>Explore our website and discover the many opportunities the library offers!</h1>
</div>
<div class="login"><!three buttons>
<form method="get" action="/memlogin">

	<input type="submit"  value="Member Login" id="user">


</form>
<br>
<form method="get" action="/emplogin">

	<input type="submit"  value="Employee Login" id="employee">
	
</form>
<br>
<form method="get" action="/managerlogin" >

	<input type="submit" value="Manager Login" id="manager">
	

</form>
</div>
<div id="footer"><!copyright>
<h2 style="text-align:center; padding-top:30px; color:#f1efea ">&copy 2019 by www.mylibrary.com</h2>
</div>
</div>
</body>
</html>