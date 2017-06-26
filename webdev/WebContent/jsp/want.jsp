<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String value = request.getParameter("want");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@IMPORT url("want.css");
</style>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
	<div id="want">
		<img alt="image" src="want.png" width="60%">
	</div>
	<div class="say">
		<h3><%=value %>가 갖고 싶어요...</h3>
	</div>
</body>
</html>