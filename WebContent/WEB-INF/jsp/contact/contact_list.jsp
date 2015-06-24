<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="/WEB-INF/pagingTag.tld" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contacts List</title>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/css/main.css">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/materialize.css"  media="screen,projection"/>
	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/materialize.js"></script>

<script type="text/javascript">
	$(function() {
		$("#ddlClass").material_select();
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
		<%@include file="/WEB-INF/jsp/header.jsp" %>
		
		<!-- fix float btn -->
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
		    <a class="btn-floating btn-large red" href="${pageContext.request.contextPath }/servlet/ContactAddUIServlet">
		      <i class="large mdi-content-add tooltipped" data-position="top" data-delay="50" data-tooltip="create"></i>
		    </a>
		</div>
				
		<div class="row">
			<div class="input-field col s3">
				<input id="txtName" type="text" value="${form.name }"/>
				<label for="txtName">Name</label>
			</div>
			<div class="input-field col s3">
				<input id="txtPhone" type="text" value="${form.phone }"/>
				<label for="txtPhone">Phone</label>
			</div>
			<div class="input-field col s3">
				<select id="ddlClass">
					<option value="0">--请选择--</option>
					<c:forEach var="item" items="${ cList}">
						<option value="${item.id }"
							<c:if test="${form.cid==item.id }">selected="selected"</c:if>>${item.name }</option>
					</c:forEach>
				</select>
				<label>Class</label>
			</div>
			<div class="input-field col s3">		
				<a id="btnSearch" class="btn wave-light wave-effect valign center">检索</a>
			</div>
		</div>

		<div class="row">
			<div class="col s12">
				<div class="row">
					<table class="striped responsive-table">
						<tr>					
							<th data-field="ID">ID</th>
							<th data-field="Name">姓名</th>
							<th data-field="Class">班级</th>
							<th data-field="Phone">手机号</th>
							<th data-field="Email">邮箱</th>
							<th data-field="Living">现居地</th>
							<th data-field="Company">公司</th>
							<th data-field="Remark">备注</th>
							<th data-field="Operate">操作</th>
						</tr>
						<c:forEach var="item" items="${list }">
							<tr>
								<td>${item.id }</td>
								<td>${item.name }</td>
								<td>${item.cname }</td>
								<td>${item.phone }</td>
								<td>${item.email }</td>
								<td>${item.living }</td>
								<td>${item.company }</td>
								<td title="${item.remark }">${fn:length(item.remark)>20?fn:substring(item.remark,0,15).concat('......') :item.remark }</td>
								<td style="padding:0px 5px">
									<a href="${pageContext.request.contextPath }/servlet/ContactUpdateUIServlet?id=${item.id}">
										<i class="small mdi-editor-mode-edit"></i>
									</a>
									<%--a onclick="return confirm('您确定要删除‘${item.name}’吗？请不要随便删除别人的信息噢！');"
									href="${pageContext.request.contextPath }/servlet/ContactDeleteServlet?id=${item.id}">删除</a>--%>
								</td>
							</tr>
						</c:forEach>
					</table>
					<br />
					<page:pageOut
						url="${pageContext.request.contextPath }/servlet/ContactListUIServlet?name=${form.name }&phone=${form.phone }&cid=${form.cid }"
						pageIndex="${page.pageIndex }" pageMax="${page.totalCount }"></page:pageOut>
				</div>
			</div>
		</div>
	
		<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>