<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Update Password</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
	<main>
	<div class="container ">
		<div class="row">
			<div class="col s12 m8 offset-m2 l6 offset-l3">
				<h4 class="header">Update Password</h4>
			</div>
		</div>
		<div class="row">
			<form class="col s12 m8 offset-m2 l6 offset-l3" 
			action="#" th:action="${pageContext.request.contextPath }/password/update" th:object="${form }" method="post">
				<div class="row">
					<div class="input-field col s12">
						<input id="oldPassword" type="password" th:field="*{oldpassword}" class='validate ${form.errors.oldpassword==null?"":"invalid tooltipped"}' name="oldpassword" value="${form.oldpassword}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.oldpassword}"/>
						<label for="oldPassword">OldPassword</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="newPassword" type="password" th:field="*{newpassword}" class='validate ${form.errors.newpassword==null?"":"invalid tooltipped"}' name="newpassword" value="${form.newpassword}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.newpassword}"/>
						<label for="newPassword">NewPassword</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="confirmPassword" type="password" th:field="*{comfirmpassword}" class='validate ${form.errors.confirmpassword==null?"":"invalid tooltipped"}' name="confirmpassword" value="${form.confirmpassword}" required 
						data-position="right" data-delay="50" data-tooltip="${form.errors.confirmpassword}"/>
						<label for="confirmPassword">ConfirmPassword</label>
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