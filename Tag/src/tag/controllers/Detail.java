package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tag.models.FileDAO;
import tag.models.FileDAOImpl;

public class Detail extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");
		String name = (String) session.getAttribute("user_name");
		Long fileId = Long.parseLong(request.getParameter("id"));
		ModelAndView mav = null;
		if (id == null && name == null) {
			mav = new ModelAndView("/WEB-INF/result.jsp");
			mav.addObject("msg", "You should try login.");
			mav.addObject("url", "login");
		} else {
			FileDAO fileDAO = FileDAOImpl.getInstance();
			mav = new ModelAndView("/WEB-INF/views/detail.jsp", "file", fileDAO.getFileDetail(fileId));
			mav.addObject("userName", name);
		}
		return mav;
	}
}
