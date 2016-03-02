﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Update Class</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>

</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
	<main>
		<div class="container">
			<div class="left-align">
				<h4 class="header">修改班级</h4>
			</div>
			<div class="row">
				<form action="#" th:action="${pageContext.request.contextPath }/class/update" th:object="${form }" method="post">
					<input type="hidden" name="id" th:field="*{id}" value="${form.id }" />
					<div class="row">
						<div class="input-field col s12">
							<input id="name" name="name" th:field="*{name}" type="text" class="validate ${form.errors.name==null?'':'invalid tooltipped'}"  value="${form.name}" required 
							data-position="right" data-delay="50" data-tooltip="${form.errors.name}">
							<label for="name">name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="vocational" name="vocational" th:field="*{vocattional}"  type="text" class="validate ${form.errors.vocational==null?'':'invalid tooltipped'}"  value="${form.vocational}" required 
							data-position="right" data-delay="50" data-tooltip="${form.errors.vocational}">
							<label for="vocational">vocational</label>
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