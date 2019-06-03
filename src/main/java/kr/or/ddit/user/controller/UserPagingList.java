package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class userPagingList
 */
@WebServlet("/userPagingList")
public class UserPagingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserPagingList.class);
	private IuserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageVO pageVo = new PageVO();
		
		
		String result = request.getParameter("page");
		String result2 = request.getParameter("pageSize");
		
		if(result == ""|| result == null){
			result = "1";
		}
		if(result2 == "" || result2 == null){
			result2 = "10";
		}
		
		int page = Integer.parseInt(result);
		int pageSize = Integer.parseInt(result2);
		
		
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		Map<String, Object> resultMap = service.getPaging(pageVo);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userPagingList");
		doGet(request, response);
	}
}
