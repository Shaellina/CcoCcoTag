package article.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;

public class ArticleList extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();

		ModelAndView mav = new ModelAndView();

		try {
			mav.setViewName("/WEB-INF/views/article/list.jsp");
			mav.addObject("lists", articleDAO.getArticleList());
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp"); // '/'를 꼭 넣자!
			mav.addObject("msg", "게시물 리스트 출력에러\n 관리자에게 문의하세요.");
			mav.addObject("url", "");
		}
		return mav;
	}
}
