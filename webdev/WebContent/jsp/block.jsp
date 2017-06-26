<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!boolean a = true;%>
<%!HashMap<String, Boolean> user = new HashMap<>();%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon">
<link rel="icon" href="../favicon.ico" type="image/x-icon">
<title>Insert title here</title>
</head>
<body>
	favicon test
	<%
	String ip = request.getRemoteAddr();

	if (!user.containsKey(ip)) {
		user.put(ip, true);
	} else {
		if (user.get(ip)) {
			out.println("당신의 아이피는" + ip + "입니다.");
		} else {
			out.println("당신의 불량유저이므로 접속을 차단합니다.");
		}
		user.replace(ip, !user.get(ip));
	}

	/* if (a && request.getRemoteAddr().equals("70.12.50.59")) {
		out.println("당신의 아이피는" + request.getRemoteAddr() + "입니다.");
	} else {
		out.println("당신의 불량유저이므로 접속을 차단합니다.");
	}
	a = !a; */
%>
	<%-- <%=request.getRemoteAddr()%><!-- windows 7 이상은 IPv6 로 출력 --> --%>
</body>
</html>