package kr.or.ddit.attribute;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class MulCalculation
 */
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MulCalculation.class);
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		logger.debug("doGet 결과값 : " + getInt(param1, param2));
		
		request.getSession().setAttribute("mulResult", getInt(param1, param2));
		
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);;
	}
	
	private int getInt(int param1, int param2){
		int result = param1 * param2;
		
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));

		
		logger.debug("doPost 결과값 : " + getInt(param1, param2));
		
		request.getSession().setAttribute("mulResult", getInt(param1, param2));
		
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);;
	}
}
