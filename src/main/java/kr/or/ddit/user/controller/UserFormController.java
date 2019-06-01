package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
	private IuserService service;
	private UserVO userVO;
	
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
		
	}

	//사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm 서블릿의 doGet");
		//사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}
	
	
	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm 서블릿의 doPost");
		request.setCharacterEncoding("utf-8");
		
		//사용자가 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1= request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		try {
			userVO = new UserVO(userId, name, pass, alias, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO dbUser = service.getUser(userId);
		if(dbUser != null){
			logger.debug("존재하는 아이디 입니다.");
			request.setAttribute("msg", "이미 존재하는 아이디 입니다.");
//			request.getRequestDispatcher("/user/userForm").forward(request, response);
			doGet(request, response);
			return;
		}
		
		//존재하지 않을 경우 {
		//		userService 객체를 통해 insertUser(userVo);
		int result1 = service.insertUser(userVO);
		//		정상적으로 입력이 된경우
		//			사용자 페이징 리스트 1페이지로 이동
		if(result1>0){
			logger.debug("insert 성공");
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}
		
		//		정상적으로 입력이 되지 않았을 경우
		//			사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
			
		//}
		
		// 존재 할 경우
		//		사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		//		이미 존재하는 userId 입니다.(alert or text로 표시)
	}
}
