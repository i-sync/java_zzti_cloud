<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加班级</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<div class="container">
		<div class="title">
			<h3>班级添加</h3>
		</div>
		<div class="main">
			<form action="${pageContext.request.contextPath }/servlet/ClassAddServlet" method="post">
				<div>
					<div>
						<span>名称：</span>
						<input type="text" name="name" value="${form.name}"/>
						<span class="error">${form.errors.name }</span>
					</div>
					<div>
						<span>专业：</span>
						<input type="text" name="vocational" value="${form.vocational }"/>
						<span class="error">${form.errors.vocational }</span>
					</div>
				</div><br/>				
				<div>
					<input type="submit" value="提交"/>
					<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/servlet/ClassListUIServlet'" value="返回"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>