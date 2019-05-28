package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImplTest {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
	private IuserService userService;
	
	
	@Before
	public void setup(){
		userService = new UserServiceImpl();
	}
	
	@Test
	public void userList() {
		/***Given***/
		/***When***/
		List<UserVO> userList = userService.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
//		logger.debug("userList : {}", userList);
	}
	
	@Test
	public void getUser(){
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVO = userService.getUser(userId);
		
		/***Then***/
		assertEquals("brown", userVO.getUserId());
//		logger.debug("brown : {}", userVO.getUserId());
	}
	
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVO pageVo = new PageVO(1,10);
		

		/***When***/
		Map<String, Object> resultMap = userService.getPaging(pageVo);
		List<UserVO> userList = (List<UserVO>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		assertEquals(11, paginationSize);

	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("페이지네이션 : {}", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);

	}
}