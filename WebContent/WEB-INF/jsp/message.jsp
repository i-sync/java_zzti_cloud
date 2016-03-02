<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Information</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>

</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
	<main>
		<div class="container section">
			<div class="row">
				<h4 class="header">Information</h4>
			</div>
			<div class="row">
				<div>
					${message }
				</div>
			</div>
		</div>
	</main>
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>