<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Contacts</title>
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
	<%@include file="/WEB-INF/jsp/header.jsp" %>
	<div class="row">
		<div class="col s12 m7">
			<div class="card large">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="${pageContext.request.contextPath }/img/office.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Card
						Title <i class="mdi-navigation-more-vert right"></i>
					</span>
					<p>
						<a href="#">This is a link</a>
					</p>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Card Title <i
						class="mdi-navigation-close right"></i></span>
					<p>Here is some more information about this product that is only
						revealed once clicked on.</p>
				</div>
			</div>
		</div>
		<div class="col s12 m5">
			<div class="card medium">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="${pageContext.request.contextPath }/img/office.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Card
						Title <i class="mdi-navigation-more-vert right"></i>
					</span>
					<p>
						<a href="#">This is a link</a>
					</p>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Card Title <i
						class="mdi-navigation-close right"></i></span>
					<p>Here is some more information about this product that is only
						revealed once clicked on.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col s12 m7">
			<div class="card large">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="${pageContext.request.contextPath }/img/office.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Card
						Title <i class="mdi-navigation-more-vert right"></i>
					</span>
					<p>
						<a href="#">This is a link</a>
					</p>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Card Title <i
						class="mdi-navigation-close right"></i></span>
					<p>Here is some more information about this product that is only
						revealed once clicked on.</p>
				</div>
			</div>
		</div>
		<div class="col s12 m5">
			<div class="card medium">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="${pageContext.request.contextPath }/img/office.jpg">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">Card
						Title <i class="mdi-navigation-more-vert right"></i>
					</span>
					<p>
						<a href="#">This is a link</a>
					</p>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Card Title <i
						class="mdi-navigation-close right"></i></span>
					<p>Here is some more information about this product that is only
						revealed once clicked on.</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>