<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
</head>
<body>
	<div class="row">
	<nav>
		<div class="nav-wrapper">
			<div class="col s12">
				<a href="#!" class="brand-logo" style="position:inherit">Contacts</a>
				<ul class="right hide-off-med-and-down">
					<li><a href="${pageContext.request.contextPath }/servlet/IndexUIServlet">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/servlet/ContactListUIServlet">联系人管理</a></li>
					<li><a href="${pageContext.request.contextPath }/servlet/ClassListUIServlet">班级管理</a></li>
					<li><a href="${pageContext.request.contextPath }/servlet/AboutUIServlet">关于</a></li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
	<div class="row">
		<div class="col s12 right-align">
			<a href="#">${user.name}</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/servlet/PasswordUpdateUIServlet">修改密码</a>&nbsp;&nbsp;
			<a href="${ pageContext.request.contextPath}/servlet/LogoutServlet">登出</a>
		</div>
	</div>
</body>
</html>