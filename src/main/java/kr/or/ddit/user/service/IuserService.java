package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.LprodVO;
import kr.or.ddit.user.model.UserVO;

public interface IuserService {
	
	/**
	* Method : userList
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	List<UserVO> userList();
	
	/**
	* Method : getUser
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 정보 조회
	*/
	UserVO getUser(String userId);
	
	/**
	* Method : getPaging
	* 작성자 : PC19
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 : 해당하는 페이지 리스트를 반환하는 메서드
	*/
	Map<String, Object> getPaging(PageVO pageVO);
}