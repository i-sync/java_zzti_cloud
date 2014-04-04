<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>联系人修改</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<style rel="stylesheet" type="text/css">
.form .title {
	display: inline-block;
	text-align: right;
	width: 50px;
}

.form div input {
	width: 150px;
}

.form div select {
	width: 154px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">
			<h3>联系人修改</h3>
		</div>
		<div class="main">
			<form
				action="${pageContext.request.contextPath }/servlet/ContactUpdateServlet"
				method="post">
				<div class="form">
					<input type="hidden" name="id" value="${form.id }" />
					<div>
						<span class="title">姓名：</span> <input type="text" name="name"
							value="${form.name}" /> <strong class="important">*</strong> <span
							class="error">${form.errors.name }</span>
					</div>
					<div>
						<span class="title">班级：</span> <select name="cid">
							<c:forEach var="item" items="${list}">
								<option value="${item.id }"
									<c:if test="${form.cid==item.id }">selected="selected"</c:if>>${item.name }</option>
							</c:forEach>
						</select> <strong class="important">*</strong> <span class="error">${form.errors.cid }</span>
					</div>
					<div>
						<span class="title">手机号：</span> <input type="text" name="phone"
							value="${form.phone}" /> <strong class="important">*</strong> <span
							class="error">${form.errors.phone }</span>
					</div>
					<div>
						<span class="title">邮箱：</span> <input type="text" name="email"
							value="${form.email}" /> <span class="error">${form.errors.email }</span>
					</div>
					<div>
						<span class="title">现居地：</span> <input type="text" name="living"
							value="${form.living}" />
					</div>
					<div>
						<span class="title">公司：</span> <input type="text" name="company"
							value="${form.company}" />
					</div>
					<div>
						<span class="title">备注：</span>
						<textarea name="remark" rows="6" cols="40">${form.remark} </textarea>
					</div>
				</div>
				<br />
				<div>
					<input type="submit" value="提交" /> <input type="button"
						onclick="window.location.href='${pageContext.request.contextPath}/servlet/ContactListUIServlet'"
						value="返回" />
				</div>
			</form>

			<br /> <strong class="important"><span>*</span>表示必输项</strong>
		</div>
	</div>
</body>
</html>