<%@page import="unit01.Dice"%>
<%@page import="unit01.Point2D"%>
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
		Point2D pt = new Point2D();
	--%>
	<%--=pt --%>
	
	<jsp:useBean id="pt" class="unit01.Point2D"/>
	<jsp:setProperty property="x" name="pt" value="1000"/>
	<jsp:setProperty property="y" name="pt" value="2000"/>
	<%=pt %>	
	<hr/>
	<% 
	// WEB-INF directory 안에 lib directory 안에 External jar 파일을 넣어서 사용하면 된다.
		Dice myDice = new Dice();
	%>
	주사위를 굴립니다 : <%=Dice.rolling() %>
</body>
</html>