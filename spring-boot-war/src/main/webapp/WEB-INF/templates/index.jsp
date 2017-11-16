<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/base.css">

</head>
<body>
	<h1 id="h">Hello world!!!${name}</h1>

	<c:url value="http://www.baidu.com" var="url"/>
	<spring:url value="http://www.qq.com" htmlEscape="true" var="springUrl"/>
	springURL: ${springUrl }<br>
	jstl url: ${url }
	<img src="/static/image/1.jpg" />
</body>
<script src="/static/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#h").click(function() {
			alert(1);
		});
	});
</script>
</html>