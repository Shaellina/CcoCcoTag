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
		Cookie[] cookies = request.getCookies();

		for (Cookie c : cookies) {
			out.println("Domain : " + c.getDomain() + "<br/>");
			out.println("Path : " + c.getPath() + "<br/>");
			out.println("Version : " + c.getVersion() + "<br/>");
			out.println(c.getName() + " : " + c.getValue() + "<br/>");
			out.println(c.getMaxAge()+"<br/><hr>");
			
			// getMaxAge()가 -1이면 브라우저 종료 시 삭제, 0이면 즉시 삭제
		}
	%>
</body>
</html>