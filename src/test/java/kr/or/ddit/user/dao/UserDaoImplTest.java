package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImplTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);
	private IuserDao userDao;
	
	//junit 실행 순서
	// @BeforeClass가 적용된 메소드가 1회 실행
	
	// 다음 구간은 @Test가 적용된 모든 메서드에 대해 반복 적용
	// @Before가 적용된 메소드 실행
	// @Test가 적용 메소드가 실행
	// @After가 적용된 메소드가 실행
	
	//@AfterClass가 적용된 메소드가 1회 실행
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	@Before
	public void setup(){
		logger.debug("setup");
		userDao = new UserDaoImpl();
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	/**
	* Method : userListTest
	* 작성자 : PC19
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	*/
	@Test
	public void userListTest() {
		/***Given***/

		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
//		logger.debug("userList : {}", userList);
	}
	
	/**
	* Method : getUserTest
	* 작성자 : PC19
	* 변경이력 :
	* Method 설명 : 사용자 조회 테스트
	*/
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		/***Then***/
		assertEquals("브라운", userVO.getName());
		logger.debug("uservo : {}", userVO.getName());
	}
	
//	//사용자 페이징 리스트 조회
//	//*****고려사항*****
//	//몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
//	//정렬 순서? : 로직 --> 파라미터화 시킬 수 있다.
//	// --> 사용자 아이디 순으로 정렬
//	
//	@Test
//	public void userPagingListTest(){
//		/***Given***/
//		PageVo pageVo = new PageVo("", "");
//
//		/***When***/
//
//		/***Then***/
//
//	}
	
	/**
	* Method : usersCntTest
	* 작성자 : PC19
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	*/
	@Test
	public void usersCntTest(){
		/***Given***/

		/***When***/
		int usersCnt = userDao.usersCount();

		/***Then***/
		assertEquals(105, usersCnt);

	}
}





