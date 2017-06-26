<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
		Calendar c = Calendar.getInstance();
		SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat now = new SimpleDateFormat("HH시 mm분 ss초");
	%>
	오늘은
	<%=today.format(c.getTime())%> 입니다.<br/>
	현재시간은 <%=now.format(c.getTime()) %> 입니다.<br/>
</body>
</html>