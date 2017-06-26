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
		//request, response, out, session 은 내장객체로 박아둠
		// 따로 선언하지 않아도 사용 가능, 단! 이름을 저렇게 적어줘야 함

		for (int i = 1; i <= 5; i++) {
			out.println(i + "<br/>");
		}
	%>

</body>
</html>