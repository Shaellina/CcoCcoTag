<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body bgcolor="red">
	이 파일은 red.jsp입니다.
	<br /> 브라우저에 배경색이 빨간색으로 나타날까요?
	<br /> 노란색으로 나타날까요?
	<hr />
	forward 액션 태그가 실행되면 이 페이지의 내용은 출력되지 않습니다.
	<br />
	<jsp:forward page="08_yellow.jsp" />
	<%--
	// jsp 액션태그는 xml로 작성 되어있어서 마지막에 '/'를 작성하지 않으면 수행되지 않는다. 
	// 반드시 '/' 입력에 잘 살펴봐야한다.
	 
	// parameter도 다음과 같은 방법으로 넘길 수 있다. Get 방식으로 전달한다.
	// forward 방식이라 url이 바뀌지 않더라도 get으로 넘길 수 있다.
	<jsp:forward page="08_yellow.jsp">
		<jsp:param value="" name="" />
		// 받을 때는 request.getParameter()로 받아야 한다.
		// getAttribute()가 아니다.
	</jsp:forward>
	 --%>
</body>
</html>