package tag.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private static org.apache.log4j.Logger logger =
	// org.apache.log4j.Logger.getLogger(DispatcherServlet.class);
	private static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	private static Map<String, AbstractController> controllerMap = new HashMap<String, AbstractController>();

	public DispatcherServlet() {
		logger.info("DispatcherServlet.constructor 수행중...");
	}

	// 생성자가 생성 된 직후 바로 init()에 접근
	// 생성 직후 설정이나 자원에 대한 open 처리에 대해서 init()에서 수행

	// 요청이 처음 들어올 때만 단 한 번 수행하고 그 이후로는 생성하지 않음
	@Override
	public void init() throws ServletException {
		logger.info("DispatcherServlet.init() 수행중...");

		InputStream is = null;
		Properties pr = new Properties(); // key & value로 생겨먹음
		String filePath = this.getClass().getResource("").getPath();
		// 현재 위치의 디렉토리 경로 값
		try {
			is = new FileInputStream(filePath + "dispatcher-servlet.properties");
			pr.load(is);

			for (Object obj : pr.keySet()) {
				String key = ((String) obj).trim();
				String classPath = (pr.getProperty(key)).trim();

				try {
					Class className = Class.forName(classPath);
					// className.newInstance();
					// newInstance()는 미리 인스턴스를 수행해둔다.
					// 그리고 Map에 담아둔다.
					controllerMap.put(key, (AbstractController) className.newInstance());
					logger.info("loader : " + key);
				} catch (Exception e) {
					e.printStackTrace();

					logger.info("failure : " + key);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("mvcboard 수행중...");
		String contextPath = request.getContextPath(); // /mvcboard 에 해당
		String action = request.getRequestURI().trim().substring(contextPath.length());
		// /article/insert 에 해당
		// http://localhost/mvcboard/article/insert

		AbstractController controller = null;
		ModelAndView mav = null;

		logger.info(action);

		controller = controllerMap.get(action);
		if (controller == null) {
			logger.info("수행할 액션이 존재하지 않습니다.");
			return;
		}
		mav = controller.handleRequestInternal(request, response);

		/*
		 * if (action.equals("/article/insert")) { controller = new
		 * ArticleInsert(); mav = controller.handleRequestInternal(request,
		 * response); } else if (action.equals("/article/insertAction")) {
		 * controller = new ArticleInsertAction(); mav =
		 * controller.handleRequestInternal(request, response); }
		 */

		if (mav != null) {
			for (String key : mav.getModel().keySet()) {
				request.setAttribute(key, mav.getModel().get(key));
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request, response);
			logger.info("go to the " + mav.getViewName());
			return;
		} else {
			logger.info("DispatcherServlet mapping error");
		}
	}
}
