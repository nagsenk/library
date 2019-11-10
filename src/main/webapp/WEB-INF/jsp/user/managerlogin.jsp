<!DOCTYPE html>
<html>
<head>
<title>Login Form</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
.bi{
	background:url("http://www.edsocialmedia.com/wp-content/uploads/2012/01/Books-and-Computers-large1.jpg");/*background class*/
 width:100%;
 height:100vh;
 background-size:cover;
 background-position:center;
 background-attachment:fixed;
}

h1{color:#e3bd31;font-size:70px;text-align:center; background:brown;font-family:georgia;}/*main name parivartan prabhat*/

#main-wrapper {/*login form area*/
width:600px;
height:570px;
margin: 6% auto;
background:white;
padding: 5px 20px;
border-radius:20px;
border: 2px solid #2c3e50;
background-attachment:fixed;
}
.avtar {/*image icon for login form*/
width:80px;
text-align:center;
}

form {border: 3px solid #f1f1f1;}/*main login form*/

input[type=text], input[type=password] {/*two types of ip username and pass*/
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {/*login and cancel buttons*/
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {/*click on button, some transperency happens */
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
.container {
  padding: 16px;
}
span.psw {/*shifting forgot password to ri8 side*/
  float: right;
  padding-top: 16px;
}
a {
  color: yellow;
}

</style>
</head>


<body class="bi">
<a href="/welcome">home</a>
<h1>Parivartan Prabhat Library</h1>

<div id="main-wrapper">  <!login form container>
<center> <h2>Login Form</h2>
<img src="http://www.dialanywhere.com/images/assets/Login/avatar.png" class="avtar" /></center><br>  <!image icon>
 <form class="myform"  action="/manager/login/next" method="post">
  
  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me</input>
	<a style="float:right" href="#">Register?</a>
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
 </div>
 
</body>
</html>
