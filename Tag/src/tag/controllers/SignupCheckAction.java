package tag.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import tag.models.UserDAO;
import tag.models.UserDAOImpl;
import tag.models.UserVO;

@WebServlet("/tag/signup_check.do")
public class SignupCheckAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println("input email : " + email);
		UserDAO userDAO = UserDAOImpl.getInstance();
		UserVO userVO = new UserVO();
		userVO.setEmail(email);

		JSONObject jsonObject = new JSONObject();
		response.setContentType("application/x-json; charset=UTF-8");
		int count = userDAO.signupCheck(userVO);
		try {
			PrintWriter pw = response.getWriter();
			if(count == 0) {
				jsonObject.put("RESULT", "True");
			}else {
				jsonObject.put("RESULT", "False");
			}
			pw.print(jsonObject);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
