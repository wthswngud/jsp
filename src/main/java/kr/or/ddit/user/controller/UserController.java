package kr.or.ddit.user.controller;

import java.io.IOException;

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

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private IuserService service;
	private UserVO userVO;
	
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
		userVO = new UserVO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userController doGet 입니다.");
		//사용자 아이디를 request객체로부터 파라미터 획득
		String userId = request.getParameter("userId");
		
		logger.debug("파라미터 아이디 : " + userId);
		
		//사용자 아이디로 사용자 정보를 조회
		userVO = service.getUser(userId);
		
		//조회 결과를 request객체에 속성으로 저장
		request.setAttribute("userVO", userVO);
		logger.debug("userVO {}", userVO);
		
		//화면을 담당하는 user.jsp로 forword
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);;
	}
}
