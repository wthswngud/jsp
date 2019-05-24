package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;

public class UserDaoImpl implements IuserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	/**
	* Method : main
	* 작성자 : PC19
	* 변경이력 :
	* @param args
	* Method 설명 :
	*/
	public static void main(String[] args) {
		/***Given***/
		IuserDao userDao = new UserDaoImpl();

		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		logger.debug("userList : {}", userList+"\n");
		
	}
	
	
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		return userList;
	}
}