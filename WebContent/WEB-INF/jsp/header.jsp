<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
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
					<li><a href="${pageContext.request.contextPath }/gallery/list">首页</a></li>
					<c:if test="${user!=null }">
						<li><a href="${pageContext.request.contextPath }/contact/list">联系人管理</a></li>
						<li><a href="${pageContext.request.contextPath }/class/list">班级管理</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath }/about/info">关于</a></li>
				</ul>
				<ul id="mobile-nav" class="side-nav right">
					<li><a href="${pageContext.request.contextPath }/gallery/list">首页</a></li>
					<c:if test="${user!=null }">
						<li><a href="${pageContext.request.contextPath }/contact/list">联系人管理</a></li>
						<li><a href="${pageContext.request.contextPath }/class/list">班级管理</a></li>
					</c:if>
					<li><a href="${pageContext.request.contextPath }/about/info">关于</a></li>
				</ul>
			</div>
		</nav>
		<div class="row" style="margin-top:10px;">
			<div class="col s12 right-align">
				<c:if test="${user!=null}">
					<a href="#!">${user.name}</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath }/password/update">修改密码</a>&nbsp;&nbsp;
					<a href="${ pageContext.request.contextPath}/logout">登出</a>
				</c:if>
				<c:if test="${user==null }">
					<a href="${pageContext.request.contextPath }/login">登录</a>
				</c:if>
			</div>
		</div>
	</header>
</body>
</html>