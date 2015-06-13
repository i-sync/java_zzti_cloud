<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact Login</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">

</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			<form
				action="${pageContext.request.contextPath}/servlet/LoginServlet"
				method="post">
				<div>
					<input type="text" name="phone" placeholder="Phone"
						value="${form.phone }"
						class='${form.errors.phone!=null?"error":"" }'
						required title="${form.errors.phone}" />
				</div>
				<div>
					<input type="password" name="password" placeholder="Password"
						class='${form.errors.password!=null?"error":"" }'
						required title="${form.errors.password }" />
				</div>
				<div>
					<input id="login-button" type="submit" value="Login" />
					<a class="forgot"
						href="${pageContext.request.contextPath }/servlet/ForgotPasswordUIServlet">Forgot
						password?</a>
				</div>
			</form>
		</div>
		<!-- ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul-->
	</div>
</body>
</html>