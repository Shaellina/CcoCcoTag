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
		String id = request.getParameter("user_id");
		String name = request.getParameter("user_name");
		String level = request.getParameter("user_level");

		if (id == null || name == null || level == null) {
	%>
	<script type="text/javascript">
		alert("당신은 로그인을 하지 않았습니다.");
		location.href = "session_form.jsp";
	</script>

	<%
		//response.sendRedirect("session_form.jsp");
		} else {
			session.setAttribute("user_id", request.getParameter("user_id"));
			session.setAttribute("user_name", request.getParameter("user_name"));
			session.setAttribute("user_level", request.getParameter("user_level"));
			response.sendRedirect("main.jsp");
		}
	%>
</body>
</html>