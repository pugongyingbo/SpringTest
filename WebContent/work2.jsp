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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link href="css/dashboard.css" rel="stylesheet">
<script src="js/ie-emulation-modes-warning.js"></script>

</head>
<body>

	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>用户ID</th>
					<th>工作内容</th>
					<th>添加时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.list" var="work">
					<tr>
						<td><s:property value="#work.id" /></td>
						<td><s:property value="#work.userId" /></td>
						<td><s:property value="#work.work" /></td>
						<td><s:property value="#work.addTime" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</body>
</html>