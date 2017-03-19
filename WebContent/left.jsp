<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link href="css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>
</head>
<body>


	<div class="col-sm-3 col-md-2 ">
		<ul class="nav nav-sidebar">

			<li><a href="userasc" target="content">人员升序</a></li>
			<li><a href="userdesc" target="content">人员降序</a></li>
			<li><a href="workasc" target="content">工作升序</a></li>
			<li><a href="workdesc" target="content">工作降序</a></li>
			<li><a href="normalman" target="content">状态正常：男</a></li>
			<li><a href="normalwoman" target="content">状态正常：女</a></li>
			<li><a href="time.jsp" target="content">按时间段查询工作</a></li>
			<li><a href="getRate" target="content">男女总工作量比率</a></li>


		</ul>
	</div>

</body>
</html>