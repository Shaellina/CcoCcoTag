<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="board.model.BoardVO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardVO boardVO = new BoardVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Long no = Long.parseLong(request.getParameter("no"));
	String count = request.getParameter("viewcount");
	if (count != null) {

		StringBuffer sql = new StringBuffer();
		int viewCount = Integer.parseInt(count);
		sql.append(" update tb_board");
		sql.append(" set viewcount=" + (viewCount + 1));
		sql.append(" where no=" + no);

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

			pstmt = conn.prepareStatement(sql.toString());
			if (pstmt.executeUpdate() != 1) {
				throw new Exception("수정되지 않았음");
			}

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	}

	StringBuffer sql2 = new StringBuffer();
	sql2.append(" select no, name, title, content, regdate, viewcount");
	sql2.append(" from tb_board");
	sql2.append(" where no=?");
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

		pstmt = conn.prepareStatement(sql2.toString());
		pstmt.setLong(1, no);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			boardVO.setNo(rs.getLong("no"));
			boardVO.setName(rs.getString("name"));
			boardVO.setTitle(rs.getString("title"));
			boardVO.setContent(rs.getString("content"));
			boardVO.setRegDate(rs.getDate("regdate"));
			boardVO.setViewCount(rs.getInt("viewcount"));
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
</head>
<body>
	<table>
		<caption>게시물 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td><%=boardVO.getNo()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=boardVO.getName()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=boardVO.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=boardVO.getContent()%></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><%=boardVO.getRegDate()%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%=boardVO.getViewCount()%></td>
		</tr>

	</table>
	<a href="list.jsp">리스트</a>
	<a href="update.jsp?no=<%=boardVO.getNo()%>">수정</a>
	<a href="delete.jsp?no=<%=boardVO.getNo()%>">삭제</a>
</body>
</html>