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
	<form action="09_actionTagTest.jsp" method="get">
		아이디 : <input type="text" name="userID"><br /> 암 &nbsp; 호 : <input
			type="password" name="user_Pwd"><br /> <input type="radio"
			name="loginCheck" value="user" checked="checked"> 사용자 <input
			type="radio" name="loginCheck" value="manager">관리자<br />
			<input type="submit" value="로그인">
	</form>
</body>
</html>