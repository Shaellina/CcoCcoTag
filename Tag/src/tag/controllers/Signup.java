package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/WEB-INF/views/signup.jsp");
	}
}