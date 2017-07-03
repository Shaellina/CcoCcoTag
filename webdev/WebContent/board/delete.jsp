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
	String num = request.getParameter("no");
	
	if(num == null) {%>
		<script type="text/javascript">
			alert("error");
			history.back();
		</script>
	<% return;}
	long no = Long.parseLong(num);
%>


	<form action="delete_action.jsp" method="get">
		<input type="hidden" name="no" value="<%=no%>" /> <input
			type="password" name="password" /> <input type="submit" value="확인" />
	</form>
</body>
</html>