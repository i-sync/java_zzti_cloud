<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级列表</title>

<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<div id="container">
		<div class="main">
			<div>
				<a href="${pageContext.request.contextPath }/servlet/ClassAddUIServlet">添加班级</a>
				<%-- <a href="${pageContext.request.contextPath }/index.jsp">首页</a> --%>
			</div>
			<br/>
			<table class="hovertable">
				<tr>
					<th style="width:40px">ID</th>
					<th style="width:100px">名称</th>
					<th style="width:200px">专业</th>
					<th style="width:80px">操作</th>
				</tr>
				<c:forEach var="item" items="${list }">
					<tr onmouseover="this.style.backgroundColor='#ffff66';"
						onmouseout="this.style.backgroundColor='#d4e3e5';">
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.vocational }</td>
						<td>
							<a href="${pageContext.request.contextPath }/servlet/ClassUpdateUIServlet?id=${item.id}">修改</a>
							<a onclick="return confirm('你确定要删除‘${item.name}’吗？')" href="${pageContext.request.contextPath }/servlet/ClassDeleteServlet?id=${item.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
</body>
</html>