<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Password</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<h1>Update Password</h1>
			<form action="${pageContext.request.contextPath }/servlet/PasswordUpdateServlet" method="post">

				<input type="password" placeholder="OldPassword" class='${form.errors.oldpassword!=null?"error":"" }' name="oldpassword" value="${form.oldpassword}" title="${form.errors.oldpassword }" required />
				<input type="password" placeholder="NewPassword" class='${form.errors.newpassword!=null?"error":"" }' name="newpassword" value="${form.newpassword}" title="${form.errors.newpassword }" required />
				
				<input type="password" placeholder="ConfirmPassword" class='${form.errors.confirmpassword!=null?"error":"" }' name="confirmpassword" value="${form.confirmpassword}" title="${form.errors.confirmpassword }" required />
				
				<input type="submit" value="Submit"/>
				<a href='${pageContext.request.contextPath}/servlet/IndexUIServlet'>Return Index</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>