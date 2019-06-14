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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@WebFilter("/*")
public class DefaultParamFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultParamFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.debug("DefaultParamFilter : doFilter");
		
		DefaultParamWrapper requestWrapper = new DefaultParamWrapper((HttpServletRequest)request);
		requestWrapper.setParameter("UNT_CD", new String[]{"LINE"});
		
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
