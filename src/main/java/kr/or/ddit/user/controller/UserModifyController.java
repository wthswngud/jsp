package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
 * Servlet implementation class UserModifyController
 */
@WebServlet("/modify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	private IuserService service = null;
	private UserVO userVO = null;
	
	
       
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("수정화면의 doGet메서드");
		
		String userId = (String)request.getParameter("userId");
		logger.debug("Id : " + userId);
		
		userVO = service.getUser(userId);
		
		request.setAttribute("userVO", userVO);
		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		logger.debug("수정화면 doPost");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String path = request.getParameter("path");
		String filename = request.getParameter("filename");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
//		String birth = "20190505";
		
		logger.debug("userId : " + userId);
		logger.debug("name : " + name);
		logger.debug("pass : " + pass);
		logger.debug("alias : " + alias);
		logger.debug("addr1 : " + addr1);
		logger.debug("addr2 : " + addr2);
		logger.debug("path : " + path);
		logger.debug("filename : " + filename);
		logger.debug("zipcd : " + zipcd);
		logger.debug("birth : " + birth);
		
		
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		
//	   SimpleDateFormat recvSimpleFormat = new SimpleDateFormat(
//	            "E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//
//	      // 여기에 원하는 포맷을 넣어주면 된다
//	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
//	            Locale.ENGLISH);
//
//	      try {
//	         Date data = recvSimpleFormat.parse(birth);
//	         birth = sdf.format(data);
//	      } catch (ParseException e) {
//	         e.printStackTrace();
//	      }
		
		String sDate7 = "2019-06-01";
	      SimpleDateFormat formatter7 = new SimpleDateFormat("yyyy-MM-dd");
	      Date date7 = null;
	      try {
	         date7 = formatter7.parse(birth);
	      } catch (ParseException e1) {
	         // TODO Auto-generated catch block
	         e1.printStackTrace();
	      }
		
	      userVO = new UserVO(userId, name, alias, pass, addr1, addr2, path, filename, zipcd, date7);
//		try {
//			userVO = new UserVO(userId, name, alias, pass, addr1, addr2, path, filename, zipcd, date7);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		logger.debug("userVO : {}", userVO);
		
		int result = service.modiUser(userVO);
		if(result>0){
			logger.debug("수정 성공");
			response.sendRedirect(request.getContextPath()+"/userPagingList");
//			request.getRequestDispatcher(request.getContextPath()+"/userPagingList").forward(request, response);
		}else{
			logger.debug("수정 실패");
			return;
		}
	}
}
