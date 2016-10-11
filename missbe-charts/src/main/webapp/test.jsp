<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("Login:" + basePath);
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TEST</title>
</head>
<body>
这是一个测试。
<iframe id="reportFrame" width="900" height= "auto"
   src="${basePath }ReportServer?reportlet=test.cpt"></iframe>  

</body>
</html>