package basic.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExceptionTest03 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("id : ");
		String userId = s.next();
		System.out.print("pw : ");
		String userPw = s.next();

		MemberVO userInfo = new MemberVO();
		userInfo.setUserId(userId);
		userInfo.setUserPw(userPw);

		try {
			userInfo = login(userInfo);
			System.out.println(userInfo.getUserName());
		} catch (LoginFailException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// System.out.println(userInfo.getUserName());
		}
		// System.out.println(DigestUtils.sha512Hex("12345678"));
		// "fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe"
	}

	public static MemberVO login(MemberVO userInfo) throws Exception {
		// Dynamic Query
		// Connection conn = null;
		// Statement stmt = null;
		// ResultSet rs = null;
		// StringBuffer sql = new StringBuffer();
		// sql.append(" SELECT user_name");
		// sql.append(" FROM t_mem");
		// sql.append(" WHERE user_id ='" + userInfo.getUserId() + "' and
		// user_pw='" + userInfo.getUserPw() + "'");

		// Parameter Query
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT user_name");
		sql.append(" FROM t_mem");
		sql.append(" WHERE user_id = ? and user_pw=?");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bigdata", "bigdata");
			// Dynamic Query
			// stmt = conn.createStatement();
			// rs = stmt.executeQuery(sql.toString());
			
			// Parameter Query			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userInfo.getUserId());
			pstmt.setString(2, userInfo.getUserPw());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userInfo.setUserName(rs.getString("user_name"));
				return userInfo;
			} else {
				throw new LoginFailException("Id or Pw가 틀렸음", userInfo);
			}
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
			// } catch (SQLException e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				// Dynamic Query
				// if (stmt != null)
				// stmt.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//	if (userInfo.getUserId().equals("whdqhd") && userInfo.getUserPw().equals(
		//		"fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe")) {
		//		userInfo.setUserName("JB");
		//		return userInfo;
		//	} else {
		//		throw new LoginFailException("Id or Pw가 틀렸음", userInfo);
		//	}
	}
}
