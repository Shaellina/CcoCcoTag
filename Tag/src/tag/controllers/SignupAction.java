package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import tag.models.UserDAO;
import tag.models.UserDAOImpl;
import tag.models.UserVO;

public class SignupAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String pwd = request.getParameter("user_pwd");
		String pwdConfirm = request.getParameter("user_pwd_confirm");
		
		ModelAndView mav = new ModelAndView("/WEB-INF/result.jsp");
		
		System.out.println(name + ", " + email + ", " + pwd+", " + pwdConfirm);
		
		if(name == null || email == null || pwd == null || pwdConfirm == null) {
			mav.addObject("msg", "Check your input value");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		} else if(name.trim().equals("")||email.trim().equals("") || pwd.trim().equals("") || pwdConfirm.trim().equals("")) { 
			mav.addObject("msg", "Check your input value");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
		
		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setEmail(email);
		userVO.setPwd(DigestUtils.sha512Hex(pwd));

		UserDAO userDAO = UserDAOImpl.getInstance();
		try {
			userDAO.signup(userVO);
			mav.addObject("msg", "Success Sign up! Welcome!");
			mav.addObject("url", "login");
		} catch (Exception e) {
			mav.addObject("msg", "Fail Sign up! Check your input!");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
