package kr.or.ddit.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;

public class UserServiceImpl implements IuserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private IuserDao userDao = new UserDaoImpl();
	
	/**
	 * Method : userList
	 * 작성자 : 손주형
	 * 변경이력 : 
	 * @return
	 * Method : 사용자 전체 리스트 조회
	 * 
	 */
	@Override
	public List<UserVO> userList() {
		return userDao.userList();
	}

	@Override
	public UserVO getUser(String userId) {
		return userDao.getUser(userId);
	}
}