package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/RequestCountFilter")
public class RequestCountFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(RequestCountFilter.class);
	// /jsp/login : 10
	// /jsp/userList : 20
	private Map<String, Integer> requestMap;

	public void init(FilterConfig fConfig) throws ServletException {
		requestMap = new HashMap<String, Integer>();
		requestMap.put("userId", 10);
		fConfig.getServletContext().setAttribute("requestMap", requestMap);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("RequestCount");
		//요청이 올때마다 uri를 체크해서 requestMap에 데이터를 한건씩 증가시켜준다.
		HttpServletRequest req = (HttpServletRequest) request;
		// /jsp/login
		String uri = req.getRequestURI();
		int reqCount = requestMap.getOrDefault(uri, 0);
		reqCount++;
		requestMap.put(uri, reqCount);
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
