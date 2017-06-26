<%@page import="java.io.IOException"%>
<%@page import="javax.xml.stream.events.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
%>
<%-- <%! %> -> member, field 변수로 정의할 때와 method를 정의할 때 왼쪽의 태그로 작성해야 한다. --%>


<%-- out 객체 같은 내장 객체는 _jsp에서만 가능하다. --%>
<%!public String commentAge(int age) {
		if (age < 20) {
			return "묘령";
		} else if (age < 30) {
			return "약관";
		} else if (age < 40) {
			return "이립";
		} else if (age < 50) {
			return "불혹";
		} else if (age < 60) {
			return "지천명";
		} else if (age < 70) {
			return "이순";
		} else {
			return "종심";
		}
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		out.println(name);
	%> --%>
	<h1><%=name%></h1>
	<h1><%=age%>
		(
		<%=commentAge(age)%>
		<%-- out 객체를 넘겨주어야 한다. --%>
		)<br />
	</h1>
	<!-- error가 아니다! -->
</body>
</html>