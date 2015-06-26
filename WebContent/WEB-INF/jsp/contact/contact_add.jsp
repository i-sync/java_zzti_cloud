<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Contact</title>
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

<script>
	$(function() {
		$("#ddlClass").material_select();
	});
</script>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>

	<main>
		<div class="container">
			<div class="left-align">
				<h4 class="header">添加联系人</h4>
			</div>
			<div class="row">
				<form class="col s12 "
					action="${pageContext.request.contextPath }/servlet/ContactAddServlet"
					method="post">
					<div class="row">
						<div class="input-field col s12">
							<input id="name" name="name" type="text" class="validate ${form.errors.name==null?'':'invalid tooltipped'}"  value="${form.name}" required 
							data-position="right" data-delay="50" data-tooltip="${form.errors.name}">
							<label for="name">name</label>
						</div>
					</div>
		
					<div class="row">
						<div class="input-field col s12">
							<select id="ddlClass" name="cid">
								<c:forEach var="item" items="${list}">
									<option value="${item.id }"
										<c:if test="${form.cid==item.id }">selected="selected"</c:if>>${item.name }</option>
								</c:forEach>
							</select>
							<label>class</label>
						</div>
					</div>
		
					<div class="row">
						<div class="input-field col s12">
							<input id="phone" name="phone" type="text" class="validate ${form.errors.phone==null?'':'invalid tooltipped'}"  value="${form.phone}" required
							data-position="right" data-delay="50" data-tooltip="${form.errors.phone}">
							<label for="phone">phone</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="email" name="email" type="email" class="validate ${form.errors.email==null?'':'invalid tooltipped'}" value="${form.email}" required
							data-position="right" data-delay="50" data-tooltip="${form.errors.email}">
							<label for="email">email</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="living" name="living" type="text"  value="${form.living}">
							<label for="living">living</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="company" name="company" type="text"  value="${form.company}">
							<label for="company">company</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="remark" name="remark" class="materialize-textarea">${form.remark}</textarea>
							<label for="remark">remark</label>
						</div>
					</div>
					<button class="btn waves-effect waves-light right" type="submit">
						Submit <i class="mdi-content-send right"></i>
					</button>
				</form>
			</div>
		</div>
	</main>

	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>