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
		// �������ع���ʲô����URL�����������ͨ��
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<String> notCheckLoginUrls = new ArrayList<String>(); // ������¼��URL
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

			// ����url��excludedUrls�У���ͨ������
			for (String url : notCheckLoginUrls) {
				if (requestUri.endsWith(url)) { // ���ڲ���ת�ĵ�ҳ��
					filterChain.doFilter(sRequest, sResponse);
					return;
				}
			}

			// ��Ҫ���������֤��URL������ �����Ƿ��ѵ�½
			// System.out.println("user=" + session.getAttribute("loginuser"));
			if (session.getAttribute("loginuser") == null) {
				// System.out.println(arg0.getContextPath());
				response.sendRedirect(request.getContextPath()
						+ "/html/login.html");
				return;
				// ����߼���������֤�����ǻ�������û���ɫ�ж��Ƿ���Ȩ��
			} else {
				filterChain.doFilter(sRequest, sResponse);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ͨ����URL��������servlet������ʵ������������
		// filterChain.doFilter(sRequest, sResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
