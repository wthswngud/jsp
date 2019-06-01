package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	/**
	* Method : insertUserTest
	* 작성자 : PC19
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 등록
	*/
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		//사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVo = new UserVO("userTest", "대덕인", "중앙로", "userTest1234",
                "대전광역시 중구 중앙로76", "영민빌딩", "", "", "34940", (Date) sdf.parse("2019-05-31"));
		
		/***When***/
		int insertCnt = userService.insertUser(userVo);

		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/**
	* Method : deleteUserTest
	* 작성자 : PC19
	* 변경이력 :
	* Method 설명 :사용자 삭제
	*/
	@Test
	public void deleteUserTest(){
		/***Given***/
		

		/***When***/
		int result = userService.deleteUser("userTest");

		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void modiUserTest() throws ParseException{
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVo = new UserVO("userTest", "브라움", "중앙로", "userTest1234",
                "대전광역시 중구 중앙로76", "영민빌딩", "", "", "34940", (Date) sdf.parse("2019-05-31"));

		/***When***/
		int result = userService.modiUser(userVo);
		
		/***Then***/
		assertEquals(1, result);
	}
}