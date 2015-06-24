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
	
	<!-- fix float btn -->
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	    <a class="btn-floating btn-large red" href="${pageContext.request.contextPath }/servlet/GalleryAddUIServlet">
	      <i class="large mdi-content-add tooltipped" data-position="top" data-delay="50" data-tooltip="create"></i>
	    </a>
	</div>
	
	<div class="row">
	<c:forEach var="item" items="${list }">
		<c:if test="${item.id!=1 && item.id%3==1 }">
			</div>
			<div class="row">
		</c:if>
			<div class="col s12 m4">
				<div class="card medium">
					<div class="card-image">
						<img class="materialboxed" data-caption="${item.caption }" src="${pageContext.request.contextPath}${item.picture}">
					</div>
					<div class="card-content left-align">
						<span class="card-title activator grey-text text-darken-4">
							${item.title } <i class="mdi-navigation-more-vert right"></i>
						</span>
						<p>
							${item.caption }
							<a href="#!">
								<i class="small mdi-editor-mode-edit right"></i>
							</a>
						</p>
					</div>
					<div class="card-reveal left-align">
						<span class="card-title grey-text text-darken-4">
							${item.title }<i class="mdi-navigation-close right"></i></span>
						<p>${item.content }</p>
					</div>
				</div>
			</div>
	</c:forEach>
	</div>
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>