<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int n1 = 100;
		int n2 = 200;
	%>
	<%
		out.println("<h1>"+n1 + " + " + n2 + " = " + (n1 + n2) + "</h1>");
	%>
<hr/>
	<h1>
		<%=n1%>
		+
		<%=n2%>
		=
		<%=n1 + n2%></h1>
</body>
</html>