package article.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;

public class ArticlePageList extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();

		int page = 1;
		int pageSize = 10;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		}
		ModelAndView mav = new ModelAndView();

		try {
			mav.setViewName("/WEB-INF/views/article/pagelist.jsp");
			mav.addObject("lists", articleDAO.getArticlePageList(page, pageSize));

			int cnt = articleDAO.getPageList(pageSize);

			List<Integer> pages = new ArrayList<>();
			int min = page - 5 <= 0 ? 1 : page - 5;
			int max = (page + 6 > cnt ? cnt : page + 6);
			int pageMax = max < min + 11 ? min + 11 : max;
			
			for (int i = min; i < (pageMax > cnt ? cnt : pageMax); i++) {
				pages.add(i);
			}
			
			if(pages.size() < 10) {
			}
			
			mav.addObject("pages", pages);
			mav.addObject("cur", page);
			mav.addObject("end", pageMax);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp"); // '/'를 꼭 넣자!
			mav.addObject("msg", "게시물 리스트 출력에러\n 관리자에게 문의하세요.");
			mav.addObject("url", "");
		}
		return mav;
	}
}
