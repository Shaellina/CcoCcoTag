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
	<form action="deleteAction" method="get">
		<input type="hidden" name="no" value="${no}"/>
		비밀번호를 입력해주세요 : <input type="password" name="pwd" autofocus="autofocus"/>
		<input type="submit" value="확인"/>
	</form>
</body>
</html>