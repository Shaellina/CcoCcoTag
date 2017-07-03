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

	long pg = 1;
	int pageSize = 10;
	long total_cnt = 0;

	try {
		pg = Long.parseLong(request.getParameter("pg"));
	} catch (Exception e) {

	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();
	StringBuffer sql_cnt = new StringBuffer();

	sql.append(" select j.* ");
	sql.append(" from (select rownum as rnum, i.*");
	sql.append(" from (select no, title, name, regdate, viewcount");
	sql.append(" from tb_board");
	sql.append(" order by no desc");
	sql.append(" ) i");
	sql.append(" ) j");
	sql.append(" where rnum between ? and ?");

	long startnum = (pg - 1) * pageSize + 1;
	long endnum = pg * pageSize;

	sql_cnt.append(" select count(*) as cnt");
	sql_cnt.append(" from tb_board");

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, startnum);
		pstmt.setLong(2, endnum);

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

		pstmt = conn.prepareStatement(sql_cnt.toString());
		rs = pstmt.executeQuery();

		if (rs.next()) {
			total_cnt = rs.getLong("cnt");
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
<body style="width: auto;">

	<table class="type08">
		<caption>게시물 리스트</caption>
		<thead>
			<tr>
				<th scope="cols">번호</th>
				<th scope="cols">작성자</th>
				<th scope="cols">제목</th>
				<th scope="cols">작성일</th>
				<th scope="cols">조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (!list.isEmpty()) {
					for (BoardVO b : list) {
			%>
				<tr>
					<td><%=b.getNo()%></td>
					<td><%=b.getName()%></td>
					<td><a
						href="content.jsp?no=<%=b.getNo()%>&viewcount=<%=b.getViewCount()%>"><%=b.getTitle()%></a></td>
					<td><%=b.getRegDate()%></td>
					<td><%=b.getViewCount()%></td>
				</tr>
			<%
					}
				}
			%>
			<tr>
				<td colspan="5">
					<%
						for (int i = 1; i <= total_cnt / pageSize; i++) {
					%> <a href="list.jsp?pg=<%=i%>"> <%=i%> </a>
			
					<%
						}
					%>
			</td>
			</tr>
		</tbody>
	</table>
	<br />
	<a href="insert.jsp">글쓰기</a>
	<br />

</body>
</html>