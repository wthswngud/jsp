package kr.or.ddit.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/selectLocale")
public class SelectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SelectLocale.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet");
		String locale = request.getParameter("locale");
		logger.debug("id : " + locale);
		if(locale==null){
			locale="ko";
		}
//		locale = locale == null ? "ko" : locale;
		
		request.setAttribute("id", locale);
		request.getRequestDispatcher("/jstl/selectLocal.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/jstl/selectLocal.jsp?id="+locale);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
		doGet(request, response);
	}
}