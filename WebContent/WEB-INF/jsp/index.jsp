<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/pagingMaterialTag.tld" prefix="page"%>
<html>
<head>
	<title>Contacts</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>
</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp" %>
	
	<c:if test="${user!=null }">
		<!-- fix float btn -->
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
		    <a class="btn-floating btn-large red" href="${pageContext.request.contextPath }/gallery/add">
		      <i class="large mdi-content-add tooltipped" data-position="top" data-delay="50" data-tooltip="create"></i>
		    </a>
		</div>
	</c:if>
	
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
								<c:if test="${user!=null }">
									<a href="${pageContext.request.contextPath}/gallery/update?id=${item.id}">
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
					url="${pageContext.request.contextPath }/gallery/list"
					pageIndex="${page.pageIndex }" pageMax="${page.totalCount }"></page:pageOut>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>