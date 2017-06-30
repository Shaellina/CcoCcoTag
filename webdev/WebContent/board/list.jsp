<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="board.model.BoardVO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	List<BoardVO> list = new LinkedList<BoardVO>();

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();

	sql.append(" select no, name, title, regdate, viewcount");
	sql.append(" from tb_board");
	sql.append(" order by no desc");

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

		pstmt = conn.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();

		while (rs.next()) {
			BoardVO bVO = new BoardVO();
			bVO.setNo(rs.getLong("no"));
			bVO.setName(rs.getString("name"));
			bVO.setTitle(rs.getString("title"));
			bVO.setRegDate(rs.getDate("regdate"));
			bVO.setViewCount(rs.getInt("viewcount"));
			list.add(bVO);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<style type="text/css">
th {
	background-color: powderblue;
}
</style>
</head>
<body>

	<table>
		<caption>게시물 리스트</caption>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			if (!list.isEmpty()) {
				for (BoardVO b : list) {
		%>
		<tr>
			<td><%=b.getNo()%></td>
			<td><%=b.getName()%></td>
			<td><a href="content.jsp?no=<%=b.getNo()%>&viewcount=<%=b.getViewCount()%>"><%=b.getTitle()%></a></td>
			<td><%=b.getRegDate()%></td>
			<td><%=b.getViewCount()%></td>
		</tr>
		<%
				}
			}
		%>

	</table>
	<br />
	<a href="insert.jsp">글쓰기</a>
	<br />

</body>
</html>