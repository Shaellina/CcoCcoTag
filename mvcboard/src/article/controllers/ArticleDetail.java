package article.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;
import article.models.ArticleVO;

public class ArticleDetail extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();

		try {
			long no = Long.parseLong(request.getParameter("no"));
			ArticleVO articleVO = articleDAO.getDetail(no);
			return new ModelAndView("/WEB-INF/views/article/detail.jsp", "articleVO", articleVO);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
			mav.addObject("msg", e.getMessage());
			mav.addObject("url", "list");
			return mav;
		}
	}
}
