<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
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

		Pattern pattern = Pattern.compile("(^[0-9]*$)");
		Matcher matcher = pattern.matcher(id);
		
		if (id.equals("") || name.equals("")) {
	%>
	<script type="text/javascript">
		alert("아이디나 이름을 입력하지 않았습니다.");
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