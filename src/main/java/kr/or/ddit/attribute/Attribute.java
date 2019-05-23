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
 * Servlet implementation class Attribute
 */
@WebServlet("/sumCalculation")
public class Attribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Attribute.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		logger.debug("doGet = 두 수 사이의 합은 : " + getInt(start, end));
		
		request.getSession().setAttribute("session", getInt(start, end));;
		
		
		request.setAttribute("request", getInt(start, end));
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);;
	}

	private int getInt(int start, int end) {
		int sum = 0;
		for(int i=start; i<=end; i++){
			sum = sum + i;
		}
		return sum;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		logger.debug("doPost = 두 수 사이의 합은 : " + getInt(start, end));
		
		request.getSession().setAttribute("session", getInt(start, end));;
		
		request.setAttribute("request", getInt(start, end));
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);;
	}
}
