<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Xin Chào</h1>
	<h2><%= request.getAttribute("name") %></h2>
	<h2><%= request.getAttribute("pass") %></h2>
</body>
</html>