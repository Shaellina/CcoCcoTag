<%@page import="java.sql.DriverManager"%>
<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	String sPassword = null;
	if (password == null || password.equals("")) {
%>
<script type="text/javascript">
	alert("비밀번호를 입력해주세요.");
	history.back();
</script>
<%
	return;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	StringBuffer sql = new StringBuffer();
	sql.append(" select password");
	sql.append(" from tb_board");
	sql.append(" where no=?");
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setLong(1, no);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			sPassword = rs.getString("password");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(rs != null) try {rs.close();}catch(Exception e){}
		if(pstmt != null) try {pstmt.close();}catch(Exception e){}
		if(conn != null) try {conn.close();}catch(Exception e){}
	}
	
	if(!DigestUtils.sha512Hex(password).equals(sPassword)) {%>
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다. 다시 입력해주세요")
		history.back()
	</script>
<%
return;}

	StringBuffer sql2 = new StringBuffer();
	sql2.append(" delete");
	sql2.append(" from tb_board");
	sql2.append(" where no=?");
	//sql2.append(" where no=? and pwd=?");
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
		pstmt = conn.prepareStatement(sql2.toString());
		pstmt.setLong(1, no);
		//pstmt.setString(2,password);
		
		if( pstmt.executeUpdate() != 1) {
			conn.rollback();
		%>
			<script type="text/javascript">
				alert("삭제 오류")
			</script>
		<%
		return;}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(rs != null) try {rs.close();}catch(Exception e){}
		if(pstmt != null) try {pstmt.close();}catch(Exception e){}
		if(conn != null) try {conn.close();}catch(Exception e){}
	}
	response.sendRedirect("list.jsp");
%>