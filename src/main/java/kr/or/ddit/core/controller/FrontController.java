package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// localhost/userList.do --> init -> 
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		logger.debug("service : {}", request.getRequestURI());
		String uri = request.getRequestURI();
		
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(request, response);
		
		ViewResolver.viewResove(viewName, request, response);
		
		
		
//		if(uri.equals("/userList.do"))
//			new UserListController().excute(request,response);
//		else if(uri.equals("/userCreate.do"))
//			new UserCreateController().excute(request,response);
		
	}
}
