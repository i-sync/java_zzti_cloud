<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>About Content</title>
	<%@include file="/WEB-INF/jsp/common.jsp" %>

</head>
<body>
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	<main>
		<div class="container section">
			<div class="left-align">
				<h4 class="header">About Contacts</h4>
			</div>
			
			<div class="row left-align">
				<div class="col s12">
					<div class="card blue-grey darken-1">
						<div class="card-content white-text">
							<span class="card-title">Materialize</span>
							<p>
								网站页面的Material设计，全部参考
								<a target="_blank" href="http://materializecss.com/">http://materializecss.com/</a>
								， 有兴趣的同学可以点击详细了解....
							</p>
						</div>
	
					</div>
				</div>
			</div>
	
			<div class="row left-align">
				<div class="col s12">
					<div class="card teal darken-1">
						<div class="card-content white-text">
							<span class="card-title">Project Source</span>
							<p>
								通讯录的项目全部托管在Github上: <a target="_blank" href="https://github.com/">https://github.com/</a>
								<br/>
								关于GIT可以去官网了解更多： <a target="_blank" href="http://git-scm.com/">http://git-scm.com/</a>
								<br/>
								项目网站:<a target="_blank" href="https://github.com/tianzhenyun/java_zzti_cloud">https://github.com/tianzhenyun/java_zzti_cloud</a>
								<br/>
								项目网站rest服务:<a target="_blank" href="https://github.com/tianzhenyun/java_zzti_cloudrest">https://github.com/tianzhenyun/java_zzti_cloudrest</a>
							</p>
						</div>
	
					</div>
				</div>
			</div>
			
			<div class="row left-align">
				<div class="col s12">
					<div class="card teal darken-1">
						<div class="card-content white-text">
							<span class="card-title"> Share your ideas and suggestions, let us improve it together ......</span>
							
							<span class="card-title"> ${result }</span>
						</div>
	
					</div>
				</div>
			</div>
		</div>
	</main>
	
	<%@include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>