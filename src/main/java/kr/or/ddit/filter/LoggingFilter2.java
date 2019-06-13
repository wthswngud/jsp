package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter2 implements Filter{
	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter2.class);
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전처리
		logger.debug("LoggingFilter doFilter 전처리");
		String uri = ((HttpServletRequest)request).getRequestURI();
		logger.debug("LoggingFilter2 doFilter 전처리 : {}", uri);
		chain.doFilter(request, response);
		
		//후처리
		logger.debug("LoggingFilter2 doFilter 후처리 : {}", uri);
	}
	
	@Override
	public void destroy() {
		
	}
}
