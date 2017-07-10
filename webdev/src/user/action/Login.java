package user.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import cookie.Cooker;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(Login.class);

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);// 전달 해주어야 한다.
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cooker cooker = new Cooker(request);
		String user_id = null;
		if (cooker.exist("user_id")) {
			user_id = cooker.getValue("user_id");
			// Cookie user_id = cooker.getCookie("user_id");
		}
		request.setAttribute("user_id", user_id);
		doProcess(request, response, "/WEB-INF/views/user/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html;charset='UTF-8'");

		HttpSession session = request.getSession();

		Cookie c = null;

		String id = request.getParameter("user_id");
		String pw = DigestUtils.sha512Hex(request.getParameter("user_pw"));
		String save = "check";
		String name = null;
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
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery(); // 원본 데이터에 조작이 가해지지 않을 때, 조작을 할 때는
										// executeUpdate();

			if (rs.next()) {
				name = rs.getString(1);

				if (save.equals(request.getParameter("save_id"))) {
					c = new Cookie("user_id", id);
					c.setMaxAge(30 * 24 * 60 * 60);
					response.addCookie(c);
				} else {
					c = new Cookie("user_id", "");
					c.setMaxAge(0);
					response.addCookie(c);
				}
				// name = rs.getString("user_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		if (name != null) {
			session.setAttribute("user_id", id);
			session.setAttribute("user_name", name);
			String save_id = request.getParameter("save_id");
			response.addCookie(Cooker.createCookie("user_id", id, save != null ? 60 * 60 * 24 * 30 : 0));

			logger.info("로그인 성공");
			request.setAttribute("msg", "로그인 성공");
			request.setAttribute("url", "Main");
			doProcess(request, response, "result.jsp");
		} else {
			logger.info("로그인 실패");
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("url", "Login");
			doProcess(request, response, "result.jsp");
		}
		//
		// String id = request.getParameter("user_id");
		// String pw = request.getParameter("user_pw");
		// System.out.println("id : " + id);
		// System.out.println("pw : " + pw);
		//
		// logger.info("id : " + id);
		// logger.info("pw : " + pw);
	}
}
