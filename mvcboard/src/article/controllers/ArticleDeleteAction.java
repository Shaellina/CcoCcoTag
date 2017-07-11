package article.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;

public class ArticleDeleteAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();

		Long no = Long.parseLong(request.getParameter("no"));
		
		String pwd = request.getParameter("pwd");
		
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			articleDAO.deleteArticle(no, pwd);
			mav.addObject("msg", "삭제 성공");
			mav.addObject("url", "list");
			return mav;
		} catch (Exception e) {
			mav.addObject("msg", "삭제 실패");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
}
