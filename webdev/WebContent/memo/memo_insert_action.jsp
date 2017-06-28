<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="memo.model.MemoVO"%>
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
	<jsp:useBean id="memo" class="memo.model.MemoVO" />
	<jsp:setProperty property="*" name="memo" />

	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuffer sql = new StringBuffer();
		sql.append(" insert into t_memo(no, name, title, content)");
		sql.append(" values(memo_seq.nextval,?,?,?)");
		boolean result = false;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//out.println("드라이버로드 성공");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memo.getName());
			pstmt.setString(2, memo.getTitle());
			pstmt.setString(3, memo.getContent());
			int n = pstmt.executeUpdate();
			result = true;
			out.println(n + "개의 입력 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	%>
	<%-- property에 *을 넣어주면 자동으로 setter를 작동한다. --%>
	<%--
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MemoVO memo = new MemoVO();
		memo.setName(name);
		memo.setTitle(title);
		memo.setContent(content);
	--%>

	<%if(result) out.println(memo);%>


</body>
</html>