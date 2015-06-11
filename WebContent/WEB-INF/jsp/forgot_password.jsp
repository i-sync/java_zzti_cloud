<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Forgot password</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<div>
		<div>
			<h3>Forgot password</h3>
		</div>
		<div>
			<form action="${pageContext.request.contextPath }/servlet/ForgotPasswordServlet" method="post">
				<div>
					<span>邮箱：</span>
					<input type="text" name="email" value="${form.email}"/>
					<span class="error">${form.errors.email }</span>
				</div>
				<div>
					<input type="submit" value="提交"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>