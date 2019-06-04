package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024)
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
	private IuserService service;
	
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
		UserVO userVO = null;
		logger.debug("userForm 서블릿의 doPost");
		request.setCharacterEncoding("utf-8");
		
		//사용자가 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String filename = request.getParameter("profile");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1= request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		String path = request.getParameter("path");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date date = null;
	      try {
	    	  if(birth!=""||birth!=null){
	    		  date = sdf.parse(birth);
	    	  }
	      } catch (ParseException e1) {
	         e1.printStackTrace();
	      }
		
		userVO = new UserVO(userId, name, pass, alias, addr1, addr2, path, filename, zipcd, date);
		
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO dbUser = service.getUser(userId);
		if(dbUser != null){
			logger.debug("존재하는 아이디 입니다.");
			request.setAttribute("msg", "이미 존재하는 아이디 입니다.");
//			request.getRequestDispatcher("/user/userForm").forward(request, response);
			doGet(request, response);
			return;
		}
		
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
		
		//존재하지 않을 경우 {
		//		userService 객체를 통해 insertUser(userVo);
		int result1 = service.insertUser(userVO);
		//		정상적으로 입력이 된경우
		//			사용자 페이징 리스트 1페이지로 이동
		if(result1>0){
			logger.debug("insert 성공");
			String msg = "등록 성공";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/userPagingList").forward(request, response);;
		}else{
			String msg = "등록 실패";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/userPagingList").forward(request, response);;
		}
		
		//		정상적으로 입력이 되지 않았을 경우
		//			사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
			
		//}
		
		// 존재 할 경우
		//		사용자 등록페이지로 이동, 사용자가 입력한 값을 input에 넣어준다.
		//		이미 존재하는 userId 입니다.(alert or text로 표시)
	}
}
