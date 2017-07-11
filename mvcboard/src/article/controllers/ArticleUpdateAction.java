package article.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import article.models.ArticleDAO;
import article.models.ArticleDAOImpl;
import article.models.ArticleVO;

public class ArticleUpdateAction extends AbstractController {

	private Logger logger = Logger.getLogger(ArticleUpdateAction.class);

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {

		Long no = Long.parseLong(request.getParameter("no"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");

		ArticleDAO articleDAO = ArticleDAOImpl.getInstance();
		try {
			String spwd = articleDAO.getCheckPassword(no);
			if (!pwd.equals(spwd)) {
				logger.info("비밀번호가 틀립니다.");
				ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
				mav.addObject("msg", "비밀번호가 틀립니다.");
				// mav.addObject("url", "/WEB-INF/views/result.jsp");
				mav.addObject("url", "javascript:history.back();");
				return mav;
			} else {
				logger.info("비밀번호가 맞습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArticleVO articleVO = new ArticleVO();

		articleVO.setNo(no);
		articleVO.setName(name);
		articleVO.setTitle(title);
		articleVO.setContent(content);
		articleVO.setPwd(pwd);

		ModelAndView mav = new ModelAndView("/WEB-INF/views/result.jsp");
		try {
			articleDAO.updateArticle(articleVO);
			System.out.println("수정 성공");

			mav.addObject("msg", "수정 성공");
			mav.addObject("url", "detail?no=" + no);
		} catch (Exception e) {
			mav.addObject("msg", "수정 실패");
			//mav.addObject("url", "javascript.history.back();");
			mav.addObject("url", "javascript:history.back();");
			e.printStackTrace();
		}
		return mav;
	}
}
