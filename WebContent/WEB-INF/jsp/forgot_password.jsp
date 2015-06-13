<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Forgot password</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>Forgot password?</h1>
			<form action="${pageContext.request.contextPath }/servlet/ForgotPasswordServlet" method="post">
					<input type="email" name="email" class='${form.errors.email!=null?"error":"" }' placeholder='Email' title="${form.errors.email }" value="${form.email}" required/>

					<input type="submit" value="Submit"/>
					<a href="${pageContext.request.contextPath }/servlet/LoginUIServlet">Come Back</a>
			</form>
		</div>
	</div>
</body>
</html>