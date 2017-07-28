package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import tag.models.UserDAO;
import tag.models.UserDAOImpl;
import tag.models.UserVO;

public class LoginAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("user_email");
		String pwd = request.getParameter("user_pwd");

		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		userVO.setPwd(DigestUtils.sha512Hex(pwd));

		ModelAndView mav = new ModelAndView("/WEB-INF/result.jsp");
		
		if(email == null || pwd == null) {
			mav.addObject("msg", "Check your input!");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
		
		try {
			UserDAO userDAO = UserDAOImpl.getInstance();
			UserVO getUser = userDAO.login(userVO);
			if (getUser == null) {
				mav.addObject("msg", "Check your email or password!");
				mav.addObject("url", "javascript:history.back();");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user_id", getUser.getId());
				session.setAttribute("user_name", getUser.getName());
				session.setMaxInactiveInterval(60*60);
				mav.addObject("url", "list");
			}
		} catch (Exception e) {
			mav.addObject("msg", "Fail Login");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
