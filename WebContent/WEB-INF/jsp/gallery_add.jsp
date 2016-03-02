<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Gallery</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
	<main>
		<div class="container">
			<div class="left-align">
				<h4 class="header">Add Gallery</h4>
			</div>
			<div class="row">
				<form class="col s12 "
					action="#" th:action="${pageContext.request.contextPath }/gallery/add" th:object="${form }"
					method="post" enctype="multipart/form-data">
					<div class="file-field input-field col s12">
						<input class="file-path validate ${form.errors.picture==null?'':'invalid tooltipped'}" type="text" readonly
							data-position="right" data-delay="50" data-tooltip="${form.errors.picture}"/>
						<div class="btn">
							<span>Image</span>
							<input type="file" name="picture" accept="image/*" required />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="title" name="title" th:field="*{title}" type="text" class="validate ${form.errors.title==null?'':'invalid tooltipped'}"  value="${form.title}" required 
							data-position="right" data-delay="50" data-tooltip="${form.errors.title}">
							<label for="title">Title</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="caption" name="caption" th:field="*{caption}" type="text" class="validate ${form.errors.caption==null?'':'invalid tooltipped'}"  value="${form.caption}" required 
							data-position="right" data-delay="50" data-tooltip="${form.errors.caption}">
							<label for="caption">Caption</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="content" name="content" th:field="*{content}" class="materialize-textarea">${form.content}</textarea>
							<label for="content">Content</label>
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