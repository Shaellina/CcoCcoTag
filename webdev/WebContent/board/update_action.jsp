<%@page import="org.apache.commons.codec.digest.DigestUtils"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%
	Long no = Long.parseLong(request.getParameter("no"));
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	String sPassword = null;

	if (password == null || password.equals("")) {
%>
<script type="text/javascript">
	alert("비밀번호를 입력해주세요.");
	history.back();
</script>
<%
return;}
    	
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
    	sql2.append(" update tb_board");
    	sql2.append(" set name=?, title=?, content=?");
    	sql2.append(" where no=?");
    	
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
    		pstmt = conn.prepareStatement(sql2.toString());
    		pstmt.setString(1, name);
    		pstmt.setString(2, title);
    		pstmt.setString(3, content);
    		pstmt.setLong(4, no);
    		
			if(pstmt.executeUpdate() < 1) {%>
				<script type="text/javascript">
					alert("수정 오류")
					return;
				</script>
			<%}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		if(rs != null) try {rs.close();}catch(Exception e){}
    		if(pstmt != null) try {pstmt.close();}catch(Exception e){}
    		if(conn != null) try {conn.close();}catch(Exception e){}
    	}
    	response.sendRedirect("content.jsp?no="+no);
    %>
</html>