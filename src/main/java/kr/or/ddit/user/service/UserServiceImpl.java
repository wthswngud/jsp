package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.LprodVO;
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

	@Override
	public Map<String, Object> getPaging(PageVO pageVO) {
		//1. List<UserVO>, userCnt를 필드로 하는 vo
		//2. List<Object> resultList = new ArrayList<Object>();
		//	 resultList.add(userList);
		//	 resultList.add(usersCnt);
		//3. Map<String, Object> resultMap = new HashMap<String, Object>();
		//	 resultMap.put("userList", userList);
		//	 resultMap.put("usersCnt, usersCnt);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<UserVO> userList = userDao.getPaging(pageVO);
		//usersCnt --> paginationSize 변경
		int usersCnt = userDao.usersCount();
		
		//pageSize --> pageVo.getPageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVO.getPageSize());
		
		map.put("userList", userList);
		map.put("paginationSize", paginationSize);
		
		return map;
	}
}