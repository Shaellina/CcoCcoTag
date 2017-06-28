<%@page import="java.net.URLEncoder"%>
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
		String sname = "제이비";
		String sid = "whdqhd";
		String spw = "1234";

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (sid.equals(id) && spw.equals(pw)) {
			response.sendRedirect("04_main.jsp?name=" + URLEncoder.encode(sname, "UTF-8"));
		} else {
			// out.print("<script> alert('아이디나 비밀번호가 틀렸습니다.'); javascript:history.back();</script>");
			// response.sendRedirect("04_loginForm.jsp");
	%>

	<script>
		alert('아이디나 비밀번호가 틀렸습니다.');
		javascript:history.back();
	</script>
	<%
		}
	%>
</body>
</html>