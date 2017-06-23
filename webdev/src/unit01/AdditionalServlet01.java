package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionalServlet01
 */
@WebServlet("/AdditionalServlet01")
public class AdditionalServlet01 extends HttpServlet {
	// WebProgramming을 위한 CGI 라는 표준 규격
	// HttpServlet이라는 것으로 만듬

	// Service라는 메소드로 분석
	// Servlet안에는 doGet, doPost, doDelete, doPut 같은 게 있다.

	// 여러 명의 다중 접속이 있을 경우에만 필요한 부분
	// private static final long serialVersionUID = 1L;

	/*
	 * GET /webdev/AdditionalServlet01?name=jung HTTP/1.1
	 */

	/*
	 * POST /webdev/AdditionalServlet01 HTTP/1.1 Host: localhost:8088
	 * Content-type : application/x-www-form-urlencoded user-agent: Mozilla/5.0
	 * Content-type : 9
	 * 
	 * name=jung
	 */

	// 하는 일이 없음
	/**
	 * @see HttpServlet#HttpServlet() / public AdditionalServlet01() { super();
	 *      // TODO Auto-generated constructor stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		System.out.println("doGet 수행중");
		String name = (request.getParameter("name"));
		System.out.println("그래, 난 " + name + ". 포기를 모르는 남자");
		// response.getWriter().append("hi! this is get method, " + name + ".");
		out.println("hi! this is get method, " + name + ".");
		out.close();

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		System.out.println("doPost 수행중");
		String name = (request.getParameter("name"));
		System.out.println("그래, 난 " + name + ". 포기를 모르는 남자");
		// response.getWriter().append("hi! this is post method, " + name +
		// ".");
		out.println("hi! this is post method, " + name + ".");
		out.close();
	}
}
