<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级列表</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/materialize.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/materialize.js"></script>

</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
	<!-- fix float btn -->
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	    <a class="btn-floating btn-large green" href="${pageContext.request.contextPath }/class/add">
	      <i class="large mdi-content-add tooltipped" data-position="top" data-delay="50" data-tooltip="create"></i>
	    </a>
	</div>
	
	<main>
		<div class="container section">
			<div class="row">
				<div class="col s12">
					<div class="row">
						<table class="striped">
							<tr>
								<th>ID</th>
								<th>名称</th>
								<th>专业</th>
								<th>操作</th>
							</tr>
							<c:forEach var="item" items="${list }">
								<tr>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td>${item.vocational }</td>
									<td style="padding: 0px 5px"><a
											href="${pageContext.request.contextPath }/class/update?id=${item.id}">
											<i class="small mdi-editor-mode-edit"></i>
										</a> <%--<a onclick="return confirm('你确定要删除‘${item.name}’吗？')" href="${pageContext.request.contextPath }/servlet/ClassDeleteServlet?id=${item.id}">删除</a> --%>
									</td>
								</tr>
							</c:forEach>
						</table>
	
					</div>
				</div>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>