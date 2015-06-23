<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Gallery</title>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath }/css/main.css">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/materialize.css"  media="screen,projection"/>
	<!--Let browser know website is optimized for mobile-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/materialize.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>

	<div class="container">
		<div class="left-align">
			<h4 class="header">Add Gallery</h4>
		</div>
		<div class="row">
			<form class="col s12 "
				action="${pageContext.request.contextPath }/servlet/GalleryAddServlet"
				method="post" enctype="multipart/form-data">
				<div class="file-field input-field col s12">
					<input class="file-path validate ${form.errors.picture==null?'':'invalid tooltipped'}" type="text"
						data-position="right" data-delay="50" data-tooltip="${form.errors.picture}"/>
					<div class="btn">
						<span>Image</span>
						<input type="file" name="picture" accept="image/*" />
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="title" name="title" type="text" class="validate ${form.errors.title==null?'':'invalid tooltipped'}"  value="${form.title}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.title}">
						<label for="title">Title</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="caption" name="caption" type="text" class="validate ${form.errors.caption==null?'':'invalid tooltipped'}"  value="${form.caption}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.caption}">
						<label for="caption">Caption</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<textarea id="content" name="content" class="materialize-textarea">${form.content}</textarea>
						<label for="content">Content</label>
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