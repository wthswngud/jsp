package kr.or.ddit.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.LprodVO;
import kr.or.ddit.user.model.UserVO;

public class UserDaoImpl implements IuserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	/**
	* Method : userList
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : 사정자 전체 조회
	*/
	public static void main(String[] args) {
		/***Given***/
		IuserDao userDao = new UserDaoImpl();
		/***When***/
		List<UserVO> userList = userDao.userList();
		/***Then***/
		logger.debug("userList : {}", userList+"\n");
		
		
		
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVO userVO = userDao.getUser(userId);
		/***Then***/
		logger.debug("userVO : {}", userVO);

	}
	
	
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		return userList;
	}


	/**
	* Method : getUser
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		UserVO userVO = sqlSession.selectOne("user.getUser", userId);
		return userVO;
	}


	/**
	* Method : getPaging
	* 작성자 : PC19
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 : 해당하는 페이지 리스트를 반환하는 메서드
	*/
	@Override
	public List<UserVO> getPaging(PageVO pageVO) {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		List<UserVO> list = sqlSession.selectList("user.userPagingList", pageVO);
		return list;
	}
	
	/**
	* Method : usersCount
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	*/
	public int usersCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (int)sqlSession.selectOne("user.usersCount");
		sqlSession.close();
		return usersCnt;
	}


}