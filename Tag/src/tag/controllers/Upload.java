package tag.controllers;

import javax.servlet.http.HttpSession;

public class Upload extends AbstractController {

	public ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String name = (String) session.getAttribute("user_name");

		ModelAndView mav = null;

		if (id == null && name == null) {
			mav = new ModelAndView("/WEB-INF/result.jsp");
			mav.addObject("msg", "You should try login.");
			mav.addObject("url", "login");
		} else {
			mav = new ModelAndView("/WEB-INF/views/upload.jsp","userName", name);
		}
		return mav;
	};
}
