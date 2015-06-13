<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>首页</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.qrcode.js"></script>
<script type="text/javascript">
	$(function() {
		//generate QR
		$("#divBarcode").qrcode({size:190,fill:"#3a3",text:"http://www.contacts09.tk/android/java_zzti_contact.apk"})
		$("#linkClass")
				.click(
						function() {
							$("#ifContent")
									.attr("src",
											"${pageContext.request.contextPath }/servlet/ClassListUIServlet");
						});

		$("#linkContact")
				.click(
						function() {
							$("#ifContent")
									.attr("src",
											"${pageContext.request.contextPath }/servlet/ContactListUIServlet");
						});
		
		$("#a_download").hover(
			function(){
				$("#div_barcode").css({left:event.pageX ,top:event.pageY});
				$("#div_barcode").show();
			},
			function(){
				$("#div_barcode").hide();
			}
		);
		$("#div_barcode").hover(
			function(){$(this).show();},
			function(){$(this).hide();}
		);
	});

	function SetPageHeight() {
		var myiframe = window.document.getElementById("ifContent");
		iframeLoaded(myiframe);
	}
	var iframeLoaded = function(iframe) {
		if (iframe.src.length > 0) {
			if (!iframe.readyState || iframe.readyState == "complete") {
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
			}
		}
	}
</script>
<style>
.mainbox {
	width: 1250px;
	margin: 10px 0px;
}

.title {
	margin: 10px;
	padding-left: 50px;
}

#left {
	float: left;
	width: 120px;
	padding: 5px;
	overflow-y: auto;	
	text-align: left;
}

#main {
	float: left;
}

ul li
{
	list-style-type:none;
}

#div_barcode
{
	display:none;
	width:210px;
    position:absolute;
    background-color:white;
    padding:4px;
}

</style>
</head>
<body>
	<div>
		<div class="title">
			<h2 style="display: inline;">通讯录</h2>
			<a id="a_download" style="margin-left: 50px;"
				href="${pageContext.request.contextPath }/android/java_zzti_contact.apk">Android版下载</a>
			
			<label style="float:right;">
				<a href="#">${user.name}</a>&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/servlet/PasswordUpdateUIServlet">修改密码</a>&nbsp;&nbsp;
				<a href="${ pageContext.request.contextPath}/servlet/LogoutServlet">登出</a>
			</label>
		</div>
		<div id="div_barcode">
			<div id="divBarcode">
				
			</div>		
			<div>
				Scan with your phone to download it!
			</div>
		</div>
		<div class="mainbox">
			<div id="left">
				<ul style="">
					<li><a id="linkClass" href="#">班级管理</a></li>
					<li><a id="linkContact" href="#">联系人管理</a></li>
				</ul>
			</div>
			<div id="main">
				<iframe id="ifContent" onload="javascript:SetPageHeight()"
					width="1100px"
					src="${pageContext.request.contextPath }/servlet/ContactListUIServlet"
					name="Content" frameborder="0"> </iframe>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>