<%@page import="javax.websocket.SendResult"%>
<%@page import="javax.tools.DocumentationTool.Location"%>
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
	<%--
		// 공통으로 들어가는 이러한 부분은 필터를 이용하면 쉽다.
		/*************************************************************/
		String id = (String) session.getAttribute("user_id");
		String name = (String) session.getAttribute("user_name");
		String level = (String) session.getAttribute("user_level");

		if (id == null || name == null) {
	--%>
	<!-- <script type="text/javascript">
		alert("당신은 로그인 하지 않았습니다.");
		location.href = "session_form.jsp";
	</script> -->
	<%--
		return; // 하단이 실행하지 않게 하기위해.. 혹시나 실행 과정에서 아랫 부분까지 실행 되는 것을 막기 위해
			// client request ----> server ----> jsp 처리 ----> scriptlet 처리 ----> server response ----> client script 실행
		}
		/*************************************************************/
	--%>

	<h1>세션 테스트 중입니다.</h1>
	현재
	<%=session.getAttribute("user_id")%><br />
	<%=session.getAttribute("user_name")%><br />
	<%=session.getAttribute("user_level")%><br /> 님께서 접속 중입니다.

	<a href="session_invalidate.jsp">로그아웃하기</a>
</body>
</html>