<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="/WEB-INF/pagingTag.tld" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>联系人列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>

<style type="text/css">
.divSearch div {
	float: left;
	margin: 5px 5px;
}
</style>

<script type="text/javascript">
	$(function() {
		$("#btnSearch")
				.click(
						function() {
							var name = $("#txtName").val();
							var phone = $("#txtPhone").val();
							var cid = $("#ddlClass").val();
							window.location.href = "${pageContext.request.contextPath}/servlet/ContactListUIServlet?name="
									+ name + "&phone=" + phone + "&cid=" + cid;
						});
	});
</script>
</head>
<body>
	<div id="container">
		<div class="main">
			<div>
				<a
					href="${pageContext.request.contextPath }/servlet/ContactAddUIServlet">添加联系人</a>
				<%-- <a href="${pageContext.request.contextPath }/index.jsp">首页</a> --%>
			</div>
			<br />
			<div class="divSearch">
				<div>
					<span>姓名：</span> <input id="txtName" type="text"
						value="${form.name }" />
				</div>
				<div>
					<span>手机号：</span> <input id="txtPhone" type="text"
						value="${form.phone }" />
				</div>
				<div>
					<span>班级：</span> <select id="ddlClass">
						<option value="0">--请选择--</option>
						<c:forEach var="item" items="${ cList}">
							<option value="${item.id }"
								<c:if test="${form.cid==item.id }">selected="selected"</c:if>>${item.name }</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<input id="btnSearch" type="button" value="检索" />
				</div>
			</div>
			<div class="clear"></div>

			<table class="hovertable">
				<tr>
					<th style="width: 40px">ID</th>
					<th style="width: 70px">姓名</th>
					<th style="width: 90px">班级</th>
					<th style="width: 100px">手机号</th>
					<th style="width: 150px">邮箱</th>
					<th style="width: 70px">现居地</th>
					<th style="width: 200px">公司</th>
					<th style="width: 200px">备注</th>
					<th style="width: 80px">操作</th>
				</tr>
				<c:forEach var="item" items="${list }">
					<tr onmouseover="this.style.backgroundColor='#ffff66';"
						onmouseout="this.style.backgroundColor='#d4e3e5';">
						<td>${item.id }</td>
						<td>${item.name }</td>
						<td>${item.cname }</td>
						<td>${item.phone }</td>
						<td>${item.email }</td>
						<td>${item.living }</td>
						<td>${item.company }</td>
						<td title="${item.remark }">${fn:length(item.remark)>20?fn:substring(item.remark,0,15).concat('......') :item.remark }</td>
						<td><a
							href="${pageContext.request.contextPath }/servlet/ContactUpdateUIServlet?id=${item.id}">修改</a>
							<a
							onclick="return confirm('您确定要删除‘${item.name}’吗？请不要随便删除别人的信息噢！');"
							href="${pageContext.request.contextPath }/servlet/ContactDeleteServlet?id=${item.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<page:pageOut
				url="${pageContext.request.contextPath }/servlet/ContactListUIServlet"
				pageIndex="${page.pageIndex }"
				pageMax="${page.totalCount }"></page:pageOut>
		</div>
	</div>
</body>
</html>