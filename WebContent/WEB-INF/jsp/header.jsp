<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<script type="text/javascript">
		$(function(){
			$(".button-collapse").sideNav();
		});
	</script>
</head>
<body>
	<header>
		<nav>
			<div class="nav-wrapper">
				<a href="#!" class="brand-logo" >Contacts</a>
				<a href="#!" data-activates="mobile-nav" class="button-collapse"><i class="mdi-navigation-menu"></i></a>
				<ul class="right hide-on-med-and-down">
					<li><a href="${pageContext.request.contextPath }/servlet/IndexUIServlet">首页</a></li>
					<c:if test="${user!=null }">
						<li><a href="${pageContext.request.contextPath }/servlet/ContactListUIServlet">联系人管理</a></li>
						<li><a href="${pageContext.request.contextPath }/servlet/ClassListUIServlet">班级管理</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath }/servlet/AboutUIServlet">关于</a></li>
				</ul>
				<ul id="mobile-nav" class="side-nav right">
					<li><a href="${pageContext.request.contextPath }/servlet/IndexUIServlet">首页</a></li>
					<c:if test="${user!=null }">
						<li><a href="${pageContext.request.contextPath }/servlet/ContactListUIServlet">联系人管理</a></li>
						<li><a href="${pageContext.request.contextPath }/servlet/ClassListUIServlet">班级管理</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath }/servlet/AboutUIServlet">关于</a></li>
				</ul>
			</div>
		</nav>
		<div class="row" style="margin-top:10px;">
			<div class="col s12 right-align">
				<c:if test="${user!=null}">
					<a href="#!">${user.name}</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/servlet/PasswordUpdateUIServlet">修改密码</a>&nbsp;&nbsp;
					<a href="${ pageContext.request.contextPath}/servlet/LogoutServlet">登出</a>
				</c:if>
				<c:if test="${user==null }">
					<a href="${pageContext.request.contextPath }/servlet/LoginUIServlet">登录</a>
				</c:if>
			</div>
		</div>
	</header>
</body>
</html>