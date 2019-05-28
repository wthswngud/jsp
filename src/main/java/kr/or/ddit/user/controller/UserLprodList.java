package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.ILprodDao;
import kr.or.ddit.user.model.LprodVO;
import kr.or.ddit.user.service.ILprodService;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.LprodServiceImpl;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserLprodList
 */
@WebServlet("/userLprodList")
public class UserLprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UserLprodList.class);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("lprod.jsp");
		ILprodService service = new LprodServiceImpl();
		PageVO pageVO = new PageVO();
		
		request.getParameter("page");
		request.getParameter("pageSize");
		
		String result = request.getParameter("page");
		String result2 = request.getParameter("pageSize");
		
		
		if(request.getParameter("page")=="" || request.getParameter("page") == null){
			result = "1";
		}
		if(request.getParameter("pageSize") == "" || request.getParameter("pageSize") == null){
			result2 = "5";
		}
		
		int page = Integer.parseInt(result);
		int pageSize = Integer.parseInt(result2);
		
		pageVO.setPage(page);
		pageVO.setPageSize(pageSize);
		
		
		List<LprodVO> list = service.getLprod();
		List<LprodVO> pageList = service.getPageLprod(pageVO);
		Map<String, Object> map = service.getPaging(pageVO);
		int pagenation = (int) map.get("pagenation");
		
		request.setAttribute("pageList", pageList);
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("pagenation", pagenation);
		
		
		request.getRequestDispatcher("/user/lprod.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
