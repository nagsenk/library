<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>User Page</title>
</head>
<body>
 
<a href="/welcome">logout</a>
 <h1>Book Info</h1>
 
 <br>
 <p1> Book Id :${book2.bid}</p1>
 <br>
 <p1> Title :${bookinfo.title }</p1>

<br>
 <p1> Price :${bookinfo.price}</p1>
 <br>
 <p1> Author :${bookinfo.author}</p1>
 
 <br>
 <p1> Category:${bookinfo.category}</p1>
 <form   action="/book/issued/${book2.bid}/${authenticate.username }" method="post">
  
  <div class="container">
    <label for="title"><b>Enter Member Id</b></label>
    <input type="number" placeholder="Enter Member Id" name="memid" required>
     
     <br>
     <br>
     
      <label for="title"><b>Return Date</b></label>
    <input type="date" placeholder="Date" name="Date" required>
     
  
<br>
   <button type="submit">Submit</button>
    
  </div>

</form>
 
</body>
</html>