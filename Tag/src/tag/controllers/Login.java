package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String name = (String) session.getAttribute("user_name");

		ModelAndView mav = null;

		if (id != null && name != null) {
			mav = new ModelAndView("/WEB-INF/result.jsp");
			mav.addObject("url", "list");
			//mav = new ModelAndView("/WEB-INF/views/list.jsp");
		} else {
			mav = new ModelAndView("/WEB-INF/views/login.jsp");
		}
		return mav;
	}
}
