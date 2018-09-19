<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>论坛</title>
</head>
<body>
	<!-- 访问session对象 -->
	${user.userName},欢迎您进入小春论坛，您当前积分为${user.credits};<br/>
	当前登陆时间：<fmt:formatDate pattern="yyyy-MM-dd" value="${user.lastVisit}" />
</body>
</html>