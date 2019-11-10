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
a{
color:yellow
}

</style>
</head>


<body class="bi">
<a href="/welcome">logout</a>
<h1>Parivartan Prabhat Library</h1>

<div id="main-wrapper">  <!login form container>
<center> <h2>Book Form</h2>
<img src="http://www.dialanywhere.com/images/assets/Login/avatar.png" class="avtar" /></center><br>  <!image icon>
 <form   action="/Book/save" >
  
  <div class="container">
    <label for="title"><b>Title</b></label>
    <input type="text" placeholder="Enter Title" name="title" required>
     <label for="title"><b>Author</b></label>
    <input type="text" placeholder="Enter Author" name="author" required>
     <label for="title"><b>Category</b></label>
    <input type="text" placeholder="Enter category" name="category" required>
     <label for="title"><b>Price</b></label>
    <input type="text" placeholder="Enter price" name="price" required>
    
  

   <button type="submit">Add</button>
    
  </div>

</form>
 </div>
 
</body>
</html>
