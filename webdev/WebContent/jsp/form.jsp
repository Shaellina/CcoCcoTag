<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="process.jsp" method="get">
		<!-- default 는 get방식 -->
		이름 : <input type="text" name="name" autofocus="autofocus"
			placeholder="name" /><br /> 나이 : <input type="number" name="age"
			value=20 placeholder="age" /><br />
			취미 : <input type="checkbox" name = game/><input type="checkbox" name = sports/><br/> <input type="submit" value="확인" />
	</form>
</body>
</html>