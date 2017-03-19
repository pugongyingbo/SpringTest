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
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script language="JavaScript" src="js/mydate.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="queryWork" method="post">
		<table>

			<tr>
				<td>开始日期</td>
				<td><input id="start" name="start"
					onfocus="MyCalendar.SetDate(this)" /></td>
			</tr>
			<tr>
				<td>结束日期</td>
				<td><input id="end" name="end" class="laydate-icon"
					onfocus="MyCalendar.SetDate(this)" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="查询"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>