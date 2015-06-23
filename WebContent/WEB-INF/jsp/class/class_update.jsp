<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>UpdateClass</title>
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
	
	<div class="container">
		<div class="left-align">
			<h4 class="header">修改班级</h4>
		</div>
		<div class="row h300">
			<form action="${pageContext.request.contextPath }/servlet/ClassUpdateServlet" method="post">
				<input type="hidden" name="id" value="${form.id }" />
				<div class="row">
					<div class="input-field col s12">
						<input id="name" name="name" type="text" class="validate ${form.errors.name==null?'':'invalid tooltipped'}"  value="${form.name}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.name}">
						<label for="name">name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="vocational" name="vocational" type="text" class="validate ${form.errors.vocational==null?'':'invalid tooltipped'}"  value="${form.vocational}" required 
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
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>