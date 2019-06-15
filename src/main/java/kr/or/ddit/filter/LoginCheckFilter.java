package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 접속여부를 확인해서(세션에 USER_INFO 속성이 존재하는지)
// 접속이 안되어 있으면 --> LOGIN화면으로 이동
// 접속이 되어있으면 정상적으로 최초요청한 리소스로 위임

// ex : /user/userList --> /login
// ex : /user/userPagingList --> /login
// ex : /login --> /login
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginCheckFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		logger.debug("uri : " + uri);
		
		//세션이 없어도 처리가 되어야 되는 것들 : /login, /js, /css, /img (.js, css, .png, .gif)
		if(uri.startsWith("/login") || uri.startsWith("/js") || uri.startsWith("/css") || uri.startsWith("/img") || uri.startsWith("/bootstrap")){
			chain.doFilter(request, response);
		// session을 체크 해야하는 대상들
			
		}else if(req.getSession().getAttribute("USER_INFO") != null){
			chain.doFilter(request, response);
			
		}else{
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + "/login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
