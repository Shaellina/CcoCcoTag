<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
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

	<%
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Context context = new InitialContext(); // 내부에서 Pooling을 할 준비
			Context envContext = (Context) context.lookup("java:/comp/env"); // 자바에서 Directory를 접근하는 방법
			DataSource ds = (DataSource) envContext.lookup("jdbc/mydbcp");
			// connection을 얻어 올 수 있다.
			// conn = DriverManager.getConnection("oracle.jdbc.OracleDriver"); 같은 방법 말고 다르게 불러온다.

			DataSource dds = (DataSource) context.lookup("java:/comp/env/jdbc/mydbcp"); // 위의 것을 한 번에 합치면 다음과 같다.

			conn = ds.getConnection();
			out.println("연결 성공");
		} catch (Exception e) {

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	%>

</body>
</html>