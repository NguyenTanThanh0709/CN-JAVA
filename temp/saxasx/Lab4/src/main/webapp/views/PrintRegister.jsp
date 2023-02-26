<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
<title>Form Register</title>
</head>
<body>

	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Info</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Name</td>
					<td><%=request.getParameter("user")%></td>

				</tr>
				<tr>
					<th scope="row">2</th>
					<td>Email</td>
					<td><%=request.getParameter("email")%></td>

				</tr>
				<tr>
					<th scope="row">3</th>
					<td>Birthday</td>
					<td><%=request.getParameter("birthday")%></td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td>Hour of birthday</td>
					<td><%=request.getParameter("birthtime")%></td>
				</tr>
				<tr>
					<th scope="row">5</th>
					<td>Gender</td>
					<td><%=request.getParameter("gender")%></td>
				</tr>
				<tr>
					<th scope="row">6</th>
					<td>From</td>
					<td><%=request.getParameter("country")%></td>
				</tr>
				<tr>
					<th scope="row">7</th>
					<td>Favorite IDE</td>
					<td>
						<c:forEach items="${f_ide}" var = "ide">
							<c:out value="${ide}"/>
							<br />
						</c:forEach>
					
					</td>
				</tr>
				<tr>
					<th scope="row">8</th>
					<td>Toeic</td>
					<td><%=request.getParameter("toeic")%></td>
				</tr>
				<tr>
					<th scope="row">9</th>
					<td>Message</td>
					<td><%=request.getParameter("message")%></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>