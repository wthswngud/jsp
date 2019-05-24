package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;

public class UserDaoImpl implements IuserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	private static SqlSession sqlSession =  MyBatisUtil.getSqlSession();
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
		UserVO userVO = sqlSession.selectOne("user.getUser", userId);
		return userVO;
	}
}