<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("#linkClass")
				.click(
						function() {
							$("#ifContent")
									.attr("src",
											"${pageContext.request.contextPath }/servlet/ClassListUIServlet");
						});

		$("#linkContact")
				.click(
						function() {
							$("#ifContent")
									.attr("src",
											"${pageContext.request.contextPath }/servlet/ContactListUIServlet");
						});
	});
</script>
<style>
body {
	height: 100%;
	position: relative;
}

.title {
	margin: 10px;
	padding-left: 50px;
}

#left {
	float: left;
	width: 120px;
	padding: 5px;
	overflow-y: auto;
	height: 580px;
	text-align: left;
}

#main {
	float: left;
}

#ifContent {
	height: 100%;
	width: 90%;
	frameborder: 0px;
	position: absolute;
}
</style>
</head>
<body>
	<div>
		<div class="title">
			<h2 style="display: inline;">通讯录</h2>
			<a style="margin-left: 50px;"
				href="${pageContext.request.contextPath }/android/java_zzti_contact.apk">android版下载</a>
		</div>
		<div id="left">
			<a id="linkClass" href="#">班级管理</a><br /> <a id="linkContact"
				href="#">联系人管理</a><br />
		</div>
		<div id="main">
			<iframe id="ifContent"
				src="${pageContext.request.contextPath }/servlet/ClassListUIServlet"
				name="Content" frameborder="0"> </iframe>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>