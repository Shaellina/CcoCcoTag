package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {
	// 앞으로 모든 action 들을 제어하기 위함

	public abstract ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response);
	// 모든 action 들이 가지고 있어야 하는 것

}
