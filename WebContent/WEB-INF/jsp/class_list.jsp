<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Class List</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>
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