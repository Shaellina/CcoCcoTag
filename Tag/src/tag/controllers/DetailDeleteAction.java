package tag.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tag.models.FileDAO;
import tag.models.FileDAOImpl;
import tag.models.FileVO;

public class DetailDeleteAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("/WEB-INF/result.jsp");
		HttpSession session  = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		//String name = (String) session.getAttribute("user_name");
		long fileId = Long.parseLong(request.getParameter("id"));
		
		FileVO fileVO = new FileVO();
		fileVO.setId(fileId);
		fileVO.setUserId(Long.parseLong(userId));
		
		FileDAO fileDAO = FileDAOImpl.getInstance();
		int n = fileDAO.deleteFile(fileVO);
		
		System.out.println("return num: " + n);
		
		switch(n) {
		case 0 :
			mav.addObject("msg", "Success DeleteAction");
			mav.addObject("url", "list");
			break;
		case 1 :
			mav.addObject("msg", "This is not yours.");
			mav.addObject("url", "javascript:history.back();");
			break;
		}
		return mav;
	}
}
