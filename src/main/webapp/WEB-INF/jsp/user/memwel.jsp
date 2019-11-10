<!doctype>
<html>
<head>
<style>
.bg{
background-image:url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuuZIYcRg6KqFOpx0FJWtdKISrRMJGyO7SP1oV4Pvu_EXYh5ks");
background-repeat:no-repeat;
background-size:cover;
text-align:center;
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
a {
  color: yellow;
}
</style>
</head>
<body>
<a href="/welcome">logout</a>
<div class="bg">
<br>

<br><br>
<div class="t1">
<br>
<h2>Reserved Books</h2>
<form action="/member/${username2}/reserved">
<input type="submit" name="t1" value="Click Here"></input>
</form>
</div>
<br><br>
<div class="t2">
<br>
<h2>Books with me</h2>
<form action="/member/${username2}/cart">
<input type="submit" name="username" value="Click Here"></input>
</form>
</div>


<br><br>
<div class="t4">
<br>
<h2>Search Books</h2>
<form action="/member/${username}/searchbooks">
<input type="submit" name="t4" value="Click Here"> </input>
</form>
</div>
<br><br>
<div class="t5">
<br>
<h2>Winnners</h2>
<form action="/winners">
<input type="submit" name="t5" value="Click Here"></input>
</form>
</div>
<br><br>

<br><br>
</div>
</body>
</html>
