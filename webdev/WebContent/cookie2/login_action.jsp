<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="javax.websocket.SendResult"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	String save = request.getParameter("save_id");
	//request.getParameterValues("save_id") != null ? request.getParameterValues("save_id")[0] : "";
	String name = null;

	Cookie c = new Cookie("save_id", id);
	c.setMaxAge(save != null ? 365 * 24 * 60 * 60 / 12 : 0);
	response.addCookie(c);

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();

	sql.append(" select user_name");
	sql.append(" from t_mem");
	sql.append(" where user_id=?");
	sql.append(" and user_pw=?");
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
		pstmt = conn.prepareStatement(sql.toString());

		pstmt.setString(1, id);
		

		rs = pstmt.executeQuery(); // 원본 데이터에 조작이 가해지지 않을 때, 조작을 할 때는 executeUpdate();

		if (rs.next()) {
			name = rs.getString(1);
			// name = rs.getString("user_name");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
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
	<%
		if (name != null) {
			out.println(name + " 회원님이 로그인 되었습니다.");
		} else {
	%>
	<script type="text/javascript">
		alert('아이디나 비밀번호가 틀렸습니다.');
		location.href = "cookie_login.jsp";
	</script>
	<%
		} //out.println("아이디나 비밀번호가 틀렸습니다.");
	%>

</body>
</html>