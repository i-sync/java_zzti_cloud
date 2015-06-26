<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/pagingMaterialTag.tld" prefix="page"%>
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
	
	<main>
		<div class="row">
		<c:forEach var="item" items="${list }" varStatus="loop">
			<c:if test="${loop.count!=1 && loop.count%3==1 }">
				</div>
				<div class="row">
			</c:if>
				<div class="col s12 m4">
					<div class="card medium">
						<div class="card-image">
							<img class="materialboxed" src="${pageContext.request.contextPath}${item.picture}">
						</div>
						<div class="card-content left-align">
							<span class="card-title activator grey-text text-darken-4">
								${item.title } <i class="mdi-navigation-more-vert right"></i>
							</span>
							<p style="margin-top:5px">
								${item.caption }
								<c:if test="${item.cid==user.id }">
									<a href="${pageContext.request.contextPath}/servlet/GalleryUpdateUIServlet?id=${item.id}">
										<i class="small mdi-editor-mode-edit right"></i>
									</a>
								</c:if>
							</p>
							<p style="margin-top:10px;font-size:12px">
								<span class="blue-text lighten-4">${item.cname }&nbsp;&nbsp;创建于:${item.addDate }</span>
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
	
		<div class="row">
			<div class="col s12">
				<page:pageOut
					url="${pageContext.request.contextPath }/servlet/IndexUIServlet"
					pageIndex="${page.pageIndex }" pageMax="${page.totalCount }"></page:pageOut>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>