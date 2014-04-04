<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
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
	.title
	{
		margin:10px;
		padding-left:50px;	
	}
	#left
	{
		float:left;
		width:120px;
		padding:5px;
	}
	#main
	{
		float:left;
	}
</style>
</head>
<body>
	<div class="title">
		<h2> 通讯录</h2>
	</div>
	<div id="left">
		<a id="linkClass" href="#">班级管理</a><br /> <a id="linkContact" href="#">联系人管理</a><br />
	</div>
	<div id="main">
		<iframe width="1100px" height="550px" id="ifContent" src="${pageContext.request.contextPath }/servlet/ClassListUIServlet" name="Content" frameborder="0"> </iframe>
	</div>
</body>
</html>