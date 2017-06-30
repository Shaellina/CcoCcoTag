<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="board.model.BoardVO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	BoardVO boardVO = new BoardVO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Long no = Long.parseLong(request.getParameter("no"));
	int viewCount = Integer.parseInt(request.getParameter("viewcount"));
	StringBuffer sql = new StringBuffer();
	StringBuffer sql2 = new StringBuffer();

	sql.append(" update tb_board");
	sql.append(" set viewcount=" + (viewCount + 1));
	sql.append(" where no=" + no);
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

		pstmt = conn.prepareStatement(sql.toString());
		if(pstmt.executeUpdate() != 1) {
			throw new Exception("수정되지 않았음");
		}
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

	sql2.append(" select no, name, title, content, regdate, viewcount");
	sql2.append(" from tb_board");
	sql2.append(" order by no desc");
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");

		pstmt = conn.prepareStatement(sql2.toString());
		
		rs = pstmt.executeQuery();
		
		boardVO.setNo(rs.getLong("no"));
		boardVO.setName(rs.getString("name"));
		boardVO.setTitle(rs.getString("title"));
		boardVO.setContent(rs.getString("content"));
		boardVO.setRegDate(rs.getDate("regdate"));
		boardVO.setViewCount(rs.getInt("viewcount"));
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