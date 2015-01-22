<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级修改</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }">
</head>
<body>
<div class="container">
		<div class="title">
			<h3>班级修改</h3>
		</div>
		<div class="main">
			<form action="${pageContext.request.contextPath }/servlet/ClassUpdateServlet" method="post">
				<input type="hidden" name="id" value="${form.id }"/>
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
					<input type="submit" value="保存"/>
					<input type="button" onclick="window.location.href='${pageContext.request.contextPath}/servlet/ClassListUIServlet'" value="返回"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>