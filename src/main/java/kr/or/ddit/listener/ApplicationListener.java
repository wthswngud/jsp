package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//contextPath -> js, css 경로 설정
// ${cp}/js/jquery.js

// application cp 속성 값을 넣어주면
// ${cp}/js/jquery.js
public class ApplicationListener implements ServletContextListener{
private static final Logger logger = LoggerFactory
		.getLogger(ApplicationListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// sce.getServletContext().setAttribute("cp", sce.getServletContext().getContextPath());
		// 위에것은 아래와 같은것.
		
		ServletContext application = sce.getServletContext();
		logger.debug("sce.getServletContext().getContextPath() : {}", sce.getServletContext().getContextPath());
		application.setAttribute("cp", sce.getServletContext().getContextPath());
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
