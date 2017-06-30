package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

// javax.servlet 에 대한 정보는 java EE에서 찾아야 함
public class Auth implements Filter {

	// init 쪽에서 자원을 사용하는 데 있어서 DB의 경우 close 같은 것을 해주는 부분
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Auth Filter destroy()");
	}

	// filter 사용하는 부분
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI().substring(contextPath.length());

		System.out.println("contextPath : " + contextPath + ", URI : " + uri);
		// session 을 만드는 부분은 제외 시켜주기 위함이다.
		if (uri.equals("/session2/session_form.jsp") || uri.equals("/session2/session_add.jsp")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
			dispatcher.forward(req, res);
			return;
		} else {
			System.out.println("Auth Filter doFilter()");

			String id = (String) req.getAttribute("user_id");
			String name = (String) req.getAttribute("user_name");
			String level = (String) req.getAttribute("user_level");

			if (id == null || name == null || level == null) {
			}
		}
	}

	// 서버가 켜질 때 맨 처음 한 번 수행하고 계속 떠있음
	// 보통 시작 시에 파일에서 읽을 게 있던가 DB에서 읽을 것이 있을 때 사용
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Auth Filter init()");

	}
}
