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
<h2>Add/Remove Members</h2>
<form action="/member/list">
<input type="submit" name="t1" value="Click Here"></input>
</form>
</div>
<br><br>
<div class="t2">
<br>
<h2>Add new book</h2>
<form action="/Book/add">
<input type="submit" name="t2" value="Click Here"></input>
</form>
</div>
<br><br>
<div class="t3">
<br>
<h2>Book Return</h2>
<form action="/book/${authenticate.username}/return">
<input type="submit" name="t3" value="Click Here"></input>
</form>
</div>
<br><br>
<div class="t4">
<br>
<h2>Book Issue</h2>
<form action="/book/${authenticate.username}/issue">
<input type="submit" name="t4" value="Click Here"> </input>
</form>
</div>
<br><br>
<div class="t5">
<br>
<h2>Lost Book Due</h2>
<form action="/employee/member/Book/lost">
<input type="submit" name="t5" value="Click Here"></input>
</form>
</div>


<br><br>
<div class="t7">
<br>
<h2>Winners This Month</h2>
<form action="/winners">
<input type="submit" name="t7" value="Click Here"></input>
</form>
</div>
<br><br>

<br><br>



<br><br>
</div>
</body>
</html>
