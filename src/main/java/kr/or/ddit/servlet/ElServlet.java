package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ElServlet.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//${userId} : request -> session -> application
		//3가지 scope 객체에 같은 이름의 속성명으로 다른 값을 설정
		request.setAttribute("userId", "brown_request");
		request.getSession().setAttribute("userId", "cony_session");
		getServletContext().setAttribute("userId", "sally_application");	//application객체에 넣는 방법
		
		//각 영역의 속성을 출력하기 위해 출력을 담당하는 el.jsp로 forward
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}

}
