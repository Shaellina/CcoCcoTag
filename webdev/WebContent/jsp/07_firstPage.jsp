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
		pageContext.setAttribute("name", "page man");
		request.setAttribute("name", "request man");
		session.setAttribute("name", "session man");
		application.setAttribute("name", "application man");

		System.out.println("firstPage.jsp : ");
		System.out.println("하나의 페이지 속성 : " + pageContext.getAttribute("name"));
		System.out.println("하나의 요청 속성 : " + request.getAttribute("name"));
		System.out.println("하나의 세션 속성 : " + session.getAttribute("name"));
		System.out.println("하나의 어플리케이션 속성 : " + application.getAttribute("name"));

		// 모두 서버에 저장되는 값들!
		// pageContext 속성은 해당 page와 상관이 있음 -> page를 빠져나가면 사라짐
		// request 속성은 화면과 상관이 있음 -> requestDispatcher와 같은 방법으로 넘어가면 유지 되지만 링크를 타고 나가거나 Url이 바뀌면 사라짐
		// session 속성은 브라우저와 상관이 있음 -> 브라우저를 끄면 사라짐 
		//                                          또는 서버의 session 속성 값 시간 제한으로 사라짐
		// application 속성은 서버와 상관이 있음 -> 서버가 죽어야 값이 사라짐

		request.getRequestDispatcher("07_secondPage.jsp").forward(request, response);
	%>
</body>
</html>