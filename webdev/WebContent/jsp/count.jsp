<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!int global_cnt = 0;%>
<%-- global_count가 계속 유지 되는 이유? -> _jspService 밖에서 있으며 서버가 꺼지지 않는 한 유지가 된다.
							  공유가 되기 때문에 global_count 같은 변수는 조심해야 한다.
							  local_count 만 _jspService에서 동작하면서 한 번 돌면 끝난다. --%>

<%-- memory에 있는 값은 사라질 수 있으므로 중요한 값이면 전역변수보다는 db에 넣어야 한다. --%>

<!-- 이 것은 소스에 남는다. -->
<%-- 이 것은 소스에 안남는다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int local_cnt = 0;

		out.print("<br> local_cnt : ");
		out.print(++local_cnt);

		out.print("<br> global_cnt : ");
		out.print(++global_cnt);
	%>

</body>
</html>