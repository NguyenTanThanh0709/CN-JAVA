<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
    	
        <div class="col-md-6 col-lg-5">
        
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            tk admin tk: thanh pass: 123 <br>
            tk user tk: hung pass: 123 <br>
            <form method="get" action="<c:url value = "/HomeController"/>" class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name ="user" id="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name = "pass" id="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>
                <div class="form-group">
                    <p>Forgot password? <a href="#">Click here</a></p>
                </div>
                <div class="form-group">
                    <p>Register? <a href="/lab06/views/register.jsp">Click here</a></p>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>