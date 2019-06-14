package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/modify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	private IuserService service = null;
	
	
	
       
	@Override
	public void init() throws ServletException {
		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("수정화면의 doGet메서드");
		UserVO userVO = new UserVO();
		
		String userId = (String)request.getParameter("userId");
		logger.debug("Id : " + userId);
		
		userVO = service.getUser(userId);
		
		request.setAttribute("userVO", userVO);
		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("수정화면 doPost");
		
		UserVO userVO = new UserVO();
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
//		String pass = request.getParameter("pass");
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
		logger.debug("alias : " + alias);
		logger.debug("addr1 : " + addr1);
		logger.debug("addr2 : " + addr2);
		logger.debug("path : " + path);
		logger.debug("filename : " + filename);
		logger.debug("zipcd : " + zipcd);
		logger.debug("birth : " + birth);
		
		//사용자가 보낸 평문 비밀번호 데이터
//		logger.debug("pass : " + pass);
		//복호화가 불가능한 암호화
//		pass = KISA_SHA256.encrypt(pass);
		
		
		if(path==null){
			userVO = service.getUser(userId);
			path = userVO.getPath();
			filename = userVO.getFilename();
		}
		
		
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = null;
	      try {
	    	  if(birth==""){
	    		  date = sdf.parse(birth);
	    	  }
	      } catch (ParseException e1) {
	         e1.printStackTrace();
	      }
	      
	      userVO = new UserVO(userId, name, alias, userVO.getPass(), addr1, addr2, path, filename, zipcd, date);
	      
	      
	      Part profile = request.getPart("profile");
			//사용자가 파일을 업로드 한경우
			if(profile.getSize()>0){
				//실제 파일명
				String contentDisposition = profile.getHeader("content-disposition");
				String fileName = PartUtil.getFileName(contentDisposition);
				String ext = PartUtil.getExt(fileName);
				
				String uploadPath = PartUtil.getUploadPath();
				File uploadFolder = new File(uploadPath);
				
				
				//파일 디스크에 쓰기
				//UUID
				if(uploadFolder.exists()){
					String filePath = uploadPath+ File.separator + UUID.randomUUID().toString() + ext;
					userVO.setPath(filePath);
					userVO.setFilename(fileName);
					profile.write(filePath);
					profile.delete();
				}else{
					logger.debug("해당 폴더가 존재하지 않습니다.");
				}
			}
		
//		try {
//			userVO = new UserVO(userId, name, alias, pass, addr1, addr2, path, filename, zipcd, date7);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		logger.debug("userVO : {}", userVO);
		
		int result = service.modiUser(userVO);
		if(result>0){
			logger.debug("수정 성공");
//			response.sendRedirect(request.getContextPath()+"/userPagingList");
			String msg = "수정이 완료되었습니다.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/userPagingList").forward(request, response);
		}else{
			logger.debug("수정 실패");
			String msg = "수정이 실패하였습니다.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/userPagingList").forward(request,response);
			return;
		}
	}
}
