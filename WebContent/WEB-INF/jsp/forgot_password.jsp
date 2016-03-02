<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Forgot password</title>

	<%@include file="/WEB-INF/jsp/common.jsp" %>

</head>
<body>	
	<%@include file="/WEB-INF/jsp/header.jsp" %>
	
	<main>
		<div class="container section">
			<div class="row">
				<div class="col s12 m8 offset-m2 l6 offset-l3">
					<h4 class="header">Forgot Password?</h4>
				</div>
			</div>
			<div class="row">
				<form class="col s12 m8 offset-m2 l6 offset-l3" 
				action="#" th:action="${pageContext.request.contextPath }/password/forgot" th:object="${form }" method="post">
					<div class="row">
						<div class="input-field col s12">
							<input id="email" type="email" name="email" th:field="*{email}" value="${form.email }"
								class='${form.errors.email==null?"":"invalid tooltipped" }'
								required data-position="right" data-delay="50"
								data-tooltip="${form.errors.email}" />
							<label for="email">Email</label>
						</div>
					</div>
					<div class="section">
						<button class="btn waves-effect waves-light right" type="submit">
							Submit <i class="mdi-content-send right"></i>
						</button>
						<p class="center-align">
							<a href="${pageContext.request.contextPath }/login">Come Back</a>
						</p>
					</div>
				</form>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>