<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="board.model.BoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");

	boolean result = false;

	BoardVO boardVO = new BoardVO();
	boardVO.setName(name);
	boardVO.setTitle(title);
	boardVO.setContent(content);
	boardVO.setPassword(password);

	Connection conn = null;
	PreparedStatement pstmt = null;

	StringBuffer sql = new StringBuffer();

	sql.append(" insert into tb_board");
	sql.append(" (no, name, title, content, password)");
	sql.append(" values(seq_board.nextval,?,?,?,?)");

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, boardVO.getName());
		pstmt.setString(2, boardVO.getTitle());
		pstmt.setString(3, boardVO.getContent());
		pstmt.setString(4, DigestUtils.sha512Hex(boardVO.getPassword()));

		if ((pstmt.executeUpdate()) == 1) {
			result = true;
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (pstmt != null) {try {pstmt.close();} catch (Exception e) {}}
		if (conn != null) {try {conn.close();} catch (Exception e) {}}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"></meta>
</head>
<body>
	<script type="text/javascript">
		
	<%if (result) {%>
		alert('글 등록 성공')
		location.href = 'list.jsp';
	<%} else {%>
		alert('글 등록 실패')
		location.href = 'javascript:history.back();'; 
		// history.back()하면 비밀번호를 제외한 나머지는 그대로 유지 되므로 재입력하기 편하다.
	<%}%>
	</script>
</body>
</html>