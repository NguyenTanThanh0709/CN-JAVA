<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>HTML Forms</h2>

<form action="<c:url value = "/GsonController"/>">
  <label for="fname">id</label><br>
  <input type="text" id="fname" name="id" value=""><br>
  <label for="lname">name</label><br>
  <input type="text" id="lname" name="name" value=""><br>
  <label for="lname">price</label><br>
  <input type="text" id="lname" name="price" value=""><br><br>
  <a href="<c:url value = "/GsonController?type=add"/>">add</a>
  <a href="<c:url value = "/GsonController?type=update"/>">update</a>
  <a href="<c:url value = "/GsonController?type=delete"/>">delete choose id</a>
  <a href="<c:url value = "/GsonController?type=print"/>">print</a>
  
</form> 

</body>
</html>