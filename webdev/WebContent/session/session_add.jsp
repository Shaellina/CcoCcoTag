<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>

	<%
		session.setAttribute("msg", "hello world!");
		session.setAttribute("today", "tired");
		session.setMaxInactiveInterval(10); // 초단위
		
		response.sendRedirect("session_status.jsp");
	%>

</body>
</html>