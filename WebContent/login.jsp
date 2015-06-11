<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<div id="login">
		<div>
			<h2>Contact Login</h2>
		</div>
		<div>
			<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
				<div>
					<span>手机号：</span>
					<input type="text" name="phone" value="${form.phone}"/>
					<span class="error">${form.errors.phone }</span>
				</div>
				<div>
					<span>密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
					<input type="password" name="password"/>
					<span class="error">${form.errors.password }</span>
				</div>
				<div>
					<input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/servlet/ForgotPasswordUIServlet">忘记密码吗?</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>