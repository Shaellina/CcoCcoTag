package tag.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.s;
import tag.models.FileDAO;
import tag.models.FileDAOImpl;
import tag.models.SearchVO;

@WebServlet("/tag/searchAction")
public class SearchAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String searchOption = request.getParameter("search_option");
		String searchWord = request.getParameter("search_word");

		SearchVO searchVO = new SearchVO();
		searchVO.setOption(searchOption);
		searchVO.setWord(searchWord);

		FileDAO fileDAO = FileDAOImpl.getInstance();
		//fileDAO.searchFile(searchVO);

	}
}
