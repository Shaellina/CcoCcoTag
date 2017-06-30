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
		/* session.removeAttribute("user_id"); // 하나씩 지울 때
		   session.removeAttribute("user_name"); // 하나씩 지울 때
		   session.removeAttribute("user_level"); // 하나씩 지울 때 
		*/

		// 하지만 세션을 제거할 때는 로그아웃을 할 때이며 한 번에 제거하는 게 맞다.
		session.invalidate();
		response.sendRedirect("session_form.jsp");
	%>
</body>
</html>