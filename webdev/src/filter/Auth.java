package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String action = request.getRequestURI();
		String result = request.getRequestURI().substring(contextPath.length());

		System.out.println("URI : " + action + ", contextPath : " + contextPath + ", path : " + result);
		// session 을 만드는 부분은 제외 시켜주기 위함이다.
		if (!(result.equals("/session2/session_form.jsp") || result.equals("/session2/session_add.jsp"))) {

			String id = (String) session.getAttribute("user_id");
			String name = (String) session.getAttribute("user_name");
			String level = (String) session.getAttribute("user_level");

			if (id == null || name == null || level == null) {
				request.setAttribute("msg", "먼저 로그인을 해야 합니다.");
				request.setAttribute("url", contextPath + "/session2/session_form.jsp");
				RequestDispatcher dispatcher = request.getRequestDispatcher(result);
				dispatcher.forward(request, response);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	// 서버가 켜질 때 맨 처음 한 번 수행하고 계속 떠있음
	// 보통 시작 시에 파일에서 읽을 게 있던가 DB에서 읽을 것이 있을 때 사용
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Auth Filter init()");

	}
}
