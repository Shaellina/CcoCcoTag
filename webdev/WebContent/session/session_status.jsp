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

	<%=(String) session.getAttribute("msg")%><br />
	<%=session.getAttribute("msg")%><br />
	<%=(String) session.getAttribute("today")%><br />
	<%=session.getAttribute("today")%><br />
	
	<a href="session_add.jsp">Create Session</a>

</body>
</html>