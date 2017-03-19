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
					<th>id</th>
					<th>姓名</th>
					<th>性别</th>
					<th>状态</th>
					<th>添加时间</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#request.userList" var="user">
					<tr>
						<td><s:property value="#user.id" /></td>
						<td><s:property value="#user.name" /></td>
						<td><s:property value="#user.sex" /></td>
						<td><s:property value="#user.status" /></td>
						<td><s:property value="#user.addTime" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>



	</div>
	<tr>
		<td width="13%" class="tocenter">共 <s:property
				value="pageBean.totalPage" /> 页
		</td>
		<td width="17%" class="tocenter">共 <s:property
				value="pageBean.allRow" /> 条记录
		</td>
		<td width="15%" class="tocenter">当前第 <s:property
				value="pageBean.currentPage" /> 页
		</td>
		<td colspan="4" width="55%" class="tocenter"><s:if
				test="%{pageBean.currentPage == 1}">第一页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
			<s:else>
				<a href="getPageList?page=1">第一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a
					href="getPageList?page=<s:property value="%{pageBean.currentPage-1}"/>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</s:else> <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a
					href="getPageList?page=<s:property value="%{pageBean.currentPage+1}"/>">下一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
				<a href="getPageList?page=<s:property value="pageBean.totalPage"/>">最后一页</a>
			</s:if> <s:else>下一页&nbsp;&nbsp;&nbsp;&nbsp; 最后一页</s:else></td>
	</tr>
</body>
</html>