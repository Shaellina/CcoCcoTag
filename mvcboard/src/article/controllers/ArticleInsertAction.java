package article.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;
import article.models.ArticleVO;

public class ArticleInsertAction extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");

		ArticleVO articleVO = new ArticleVO();

		articleVO.setName(name);
		articleVO.setTitle(title);
		articleVO.setContent(content);
		articleVO.setPwd(pwd);

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance(); // Up Casting
		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			articleDAO.insertArticle(articleVO);
			System.out.println("등록 성공");

			mav.addObject("msg", "등록 성공");
			mav.addObject("url", "list");
		} catch (Exception e) {
			mav.addObject("msg", "등록 실패");
			mav.addObject("url", "javascript.history.back();");
			e.printStackTrace();
		}

		return mav;
	}

}
