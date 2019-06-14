package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* LoginController.java
* 로그인 처리 컨트롤러
*
* @author 손주형
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC19 최초 생성
*
* </pre>
*/
// web.xml servlet, servlet-mapping --> java annotation
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	
	private IuserService service;
	private UserVO userVO;
    
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
		userVO = new UserVO();
	}

	//사용자 로그인 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginController doGet()");
		logger.debug("parameter UNT_CD : {}" + request.getParameter("UNT_CD"));
		
		//login 화면을 처리해줄 누군가?? 에게 위임
		//단순 login화면을 html로 응답을 생성해주는 작업이 필요
		//이미 만들어 놓은 /login/login.jsp 로 위임 --> 별도의 상태 변경을 가하는 요청이 아니기 때문에
		//										dispatch방식으로 위임
		
		//session에 사용자 정보가 있을 경우 --> main 화면으로 이동
//		if(){
//			for(){
//				
//			}
//		}
		
		//session에 사용자 정보가 없을 경우 --> 기존 로직
		
//		RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
		//= 아래 것과 같다
		
		if(request.getSession().getAttribute("USER_INFO") == null){
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}

	//로그인 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("로그인 처리화면 : doPost");
		logger.debug("parameter UNT_CD : {}" + request.getParameter("UNT_CD"));
		logger.debug("parameter userPW : {}" + request.getParameter("userPW"));
		logger.debug("parameter rememberme: {}", request.getParameter("rememberme"));
		
		
		for(Cookie cookie : request.getCookies()){
			logger.debug("cookie : {}, {}", cookie.getName(), cookie.getValue());
		}
		
		//사용자 파라미터 userId, password
		String userId = request.getParameter("userId");
		String userPW = request.getParameter("userPW");
		String encryptPassword = KISA_SHA256.encrypt(userPW);
		logger.debug(encryptPassword);
		
		//db에서 해당사용자의 정보조회(service, dao)
		
		//해당 사용자 정보를 이용하여 사용자가 보낸 userId, password가 일치하는지 검사
		// -->userId : brown이고 password : brown1234라는 값일 때 통과, 그 이외 값은 불일치
		
		if(userId == null){
			logger.debug("userId : " + userId);
			return;
		}
		
		userVO = service.getUser(userId);
		
		//일치하면...(로그인 성공) ==> main화면으로 이동
		if(userVO != null && userVO.getPass().equals(encryptPassword)){
			logger.debug("userPW : " + userPW);
			
			//remember 파라미터가 존재할 경우 userId, rememberme cookie 설정한다.
			//remember 파라미터가 존재하지 않을 경우 userId, rememberme cookie 삭제한다.
			int cookieMaxAge = 0;
			if(request.getParameter("rememberme") != null)
//			{
				cookieMaxAge = 60*60*24*30;
				
				/*
				Cookie userIdCookie = new Cookie("userId", userId);
				userIdCookie.setMaxAge(60*60*24*30);
				
				Cookie rememberMeCookie = new Cookie("rememberme", "true");
				rememberMeCookie.setMaxAge(60*60*24*30);
				
				response.addCookie(userIdCookie);
				response.addCookie(rememberMeCookie);
				*/
				
//			}else{
				Cookie userIdCookie = new Cookie("userId", userId);
				userIdCookie.setMaxAge(cookieMaxAge);
				
				Cookie rememberMeCookie = new Cookie("rememberme", "true");
				rememberMeCookie.setMaxAge(cookieMaxAge);
				
				response.addCookie(userIdCookie);
				response.addCookie(rememberMeCookie);
//			}
			
			//session에 사용자 정보를 넣어준다(사용빈도가 높기 때문에)
			HttpSession session =  request.getSession();
			session.setAttribute("USER_INFO", userVO);
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		}else{//불일치하면...(id 혹은 pw를 잘못 입력) ==> 로그인 화면으로 이동
			//로그인화면으로 이동 : localhost/jsp/login
			//현상황에서 /jsp/login url로 dispatch 방식으로 위임이 불가
			//request.getMethod();	//GET, POST
			
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/login");이건 사용 하지말자
		}
	}
}