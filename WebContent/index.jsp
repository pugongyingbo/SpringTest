<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<frameset cols="15%,*" frameborder="no" border="0" framespacing="0">

	<frame scrolling="no" src="<%=basePath%>left.jsp" name="left">

	<frame src="<%=basePath%>main.jsp" name="content">

</frameset>

<noframes>
	<body>
	</body>
</noframes>
</html>