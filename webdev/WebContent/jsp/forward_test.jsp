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
		// requestDispatcher는 sendRedirect와는 다르다.
		// response.sendRedirect는 URL까지도 입력한 곳으로 변경된다.
		// requestDispatcher는 URL은 현재의 주소이지만 뷰는 입력한 곳의 나오게 된다.
		// 나중에 MVC 패턴을 이용을 할 때 분리하기 좋다.

		// MVC : Model, View, Controller
		// MVP : Model, View, Presenter
		RequestDispatcher dispatcher = request.getRequestDispatcher("calendar.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>