<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Reset password</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>

</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
	
	<main>
		<div class="container section">
			<div class="row">
				<div class="col s12 m8 offset-m2 l6 offset-l3">
					<h4 class="header">Reset Password</h4>
				</div>
			</div>
			<div class="row">
				<form class="col s12 m8 offset-m2 l6 offset-l3"
				action="#" th:action="${pageContext.request.contextPath }/password/reset?guid=${param.guid}" th:object="${form }" method="post">
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
					
					<div class="section">
						<button class="btn waves-effect waves-light right" type="submit">
							Submit <i class="mdi-content-send right"></i>
						</button>
						<p class="center-align">
							<a href="#!" onclick="window.close();">Close Windows</a>
						</p>				
					</div>
				</form>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>