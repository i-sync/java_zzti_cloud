<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<nav>
		<div class="nav-wrapper">
			<a href="#" class="brand-logo">Contacts</a>
			<ul id="nav-mobile" class="right hide-off-med-and-down">
				<li class="active"><a href="${pageContext.request.contextPath }/servlet/IndexUIServlet">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/servlet/ContactListUIServlet">联系人管理</a></li>
				<li><a href="${pageContext.request.contextPath }/servlet/ClassListUIServlet">班级管理</a></li>
				<li><a href="/about.html">关于</a></li>
			</ul>
		</div>
	</nav>
	<div class="row">
		<div class="col s12 right-align">
			<a href="#">${user.name}</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/servlet/PasswordUpdateUIServlet">修改密码</a>&nbsp;&nbsp;
			<a href="${ pageContext.request.contextPath}/servlet/LogoutServlet">登出</a>
		</div>
	</div>
</body>
</html>