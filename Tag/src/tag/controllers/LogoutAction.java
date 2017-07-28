package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tag.models.UserDAO;
import tag.models.UserDAOImpl;
import tag.models.UserVO;

public class LogoutAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String name = (String) session.getAttribute("user_name");

		ModelAndView mav = new ModelAndView("/WEB-INF/result.jsp");
		if (id != null && name != null) {
			session.invalidate();
			//mav.addObject("msg", "See you~");
			mav.addObject("url", "login");
		} else {
			mav.addObject("msg", "You should try login.");
			mav.addObject("url", "login");
		}
		return mav;
	}

}
