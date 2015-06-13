<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Reset password</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>Reset password</h1>
			<form action="${pageContext.request.contextPath }/servlet/ResetPasswordServlet?guid=${param.guid}" method="post">

				<input type="password" placeholder="NewPassword" class="${form.errors.newpassword!=null?'error':'' }" name="newpassword" value="${form.newpassword}" title="${form.errors.newpassword }" required />
				<input type="password" placeholder="ConfirmPassword" class="${form.errors.confirmpassword!=null?'error':'' }" name="confirmpassword" value="${form.confirmpassword}" title="${form.errors.confirmpassword }" required />
				
				<input type="submit" value="Submit"/>
				<a href="#" onclick="window.close();">Close Windows</a>
			</form>
		</div>
	</div>
</body>
</html>