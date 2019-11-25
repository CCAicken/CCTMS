package servlet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HttpServlet implements Filter {

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// 定义拦截规则，什么样的URL请求可以运行通过
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<String> notCheckLoginUrls = new ArrayList<String>(); // 不检查登录的URL
		notCheckLoginUrls.add("login.html");
		notCheckLoginUrls.add("adminlogin");
		notCheckLoginUrls.add("fileuploadservlet.do");

		try {
			String requestUri = request.getRequestURI();

			if (requestUri.endsWith(".js") || requestUri.endsWith(".css")
					|| requestUri.endsWith(".png")
					|| requestUri.endsWith(".jpg")
					|| requestUri.endsWith(".ico")
					|| requestUri.endsWith(".gif")
					|| requestUri.endsWith(".json")
					|| requestUri.endsWith(".woff")
					|| requestUri.endsWith(".tff")) {
				filterChain.doFilter(sRequest, sResponse);
				return;
			}

			// 请求url在excludedUrls中，这通过拦截
			for (String url : notCheckLoginUrls) {
				if (requestUri.endsWith(url)) { // 属于不跳转的的页面
					filterChain.doFilter(sRequest, sResponse);
					return;
				}
			}

			// 需要进行身份验证的URL、请求 则检查是否已登陆
			// System.out.println("user=" + session.getAttribute("loginuser"));
			if (session.getAttribute("loginuser") == null) {
				// System.out.println(arg0.getContextPath());
				response.sendRedirect(request.getContextPath()
						+ "/html/login.html");
				return;
				// 如果高级别的身份验证，我们还需根据用户角色判断是否有权限
			} else {
				filterChain.doFilter(sRequest, sResponse);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 通过的URL继续访问servlet容器，实现正常的请求
		// filterChain.doFilter(sRequest, sResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
