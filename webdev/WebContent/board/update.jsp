<%@page import="board.model.BoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Long no = Long.parseLong(request.getParameter("no"));

	BoardVO boardVO = null;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();

	sql.append(" select name, title, content");
	sql.append(" from tb_board");
	sql.append(" where no=?");

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, no);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			boardVO = new BoardVO();
			boardVO.setName(rs.getString("name"));
			boardVO.setTitle(rs.getString("title"));
			boardVO.setContent(rs.getString("content"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try{rs.close();}catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();}catch(Exception e){}
		if(conn != null) try{conn.close();}catch(Exception e){}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />

</head>
<body>
	<form action="update_action.jsp" method="get">
		<table>
			<caption>게시물 입력</caption>
			<tr>
				<input type="hidden" name="no" value="<%=no%>"/>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" maxlength="6" value="<%=boardVO.getName()%>" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=boardVO.getTitle()%>"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="40" rows="5" name="content"><%=boardVO.getContent()%></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="수정 완료" />
	</form>
</body>
</html>