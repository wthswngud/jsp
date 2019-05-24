package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

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
}