package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/userList")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserListController.class);

	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet 여기까지는 왔어 ㅇ.ㅇ");
		
		
		//userList객체를 userList.jsp에서 참고할 수 있도록 request객체에 속성으로 넣어준다.
		request.setAttribute("userList", userService.userList());
		
		//userList객체를 이용하여 사용자 화면을 생성하는 jsp
		request.getRequestDispatcher("/user/userList.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
