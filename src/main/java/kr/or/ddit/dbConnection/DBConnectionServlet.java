package kr.or.ddit.dbConnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(urlPatterns="/DBConnectionServlet", loadOnStartup=1)
public class DBConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DBConnectionServlet.class);
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("DbConnectionServlet init()");
		
		//basicDatasource 객체를 생성 --> application 객체에 속성으로 저장
		
		BasicDataSource bs = new BasicDataSource();
		bs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bs.setUsername("pc19");
		bs.setPassword("java");
		bs.setInitialSize(20);
		
		ServletContext application = config.getServletContext();
		application.setAttribute("bs", bs);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("DbConnectionServlet doGet()");
	}

}
