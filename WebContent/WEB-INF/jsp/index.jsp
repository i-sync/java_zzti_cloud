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
		<div class="col s12 m6">
			<div class="card large">
				<div class="card-image">
					<img class="materialboxed" src="${pageContext.request.contextPath }/img/091-2.JPG">
				</div>
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">编码091-092 <i class="mdi-navigation-more-vert right"></i>
					</span>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">编码091-092 <i
						class="mdi-navigation-close right"></i></span>
					<p>
					&nbsp;&nbsp;事过境迁，淡定若菊，激情湮没于时间的洪荒里，终日絮絮叨叨，对着墙上的孤影，对着杯里的残茗，对着青冷的荧屏，对着静默的三寸白笺，然后一切皆在梦里释放。
					</p><p>
　　					&nbsp;&nbsp;一首音乐，播放着谁的心事？感性的自己竟会听着泪流满面，寂静的夜里，听着这首《中工颂》，梳理着如歌的岁月，抒写着如梦的诗行。是想起推荐这首歌的朋友，还是感动于歌曲本身忧伤的旋律，兴许都有吧。
					</p><p>
　　					&nbsp;&nbsp;还好吗？久违的问候自遥远的天际，自浩渺的网络，自魂之幽远，自灵之深处，直抵柔软的心房。总有种期待和向往，如冬之严寒渴盼春暖花开，如涓涓细流渴盼流向大海，只有回不去少年时光，令人徒生怅惘。
					</p>
				</div>
			</div>
		</div>
		<div class="col s12 m6">
			<div class="card large">
				<div class="card-image">
					<img class="materialboxed" src="${pageContext.request.contextPath }/img/office.jpg">
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