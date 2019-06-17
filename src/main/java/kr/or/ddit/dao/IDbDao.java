package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.uri.model.DbVO;

public interface IDbDao {
	/**
	* Method : selectUri
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : uri정보 전체 조회
	*/
	List<DbVO> getUriClassMapping();
	
	/**
	* Method : selectUri
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : uri를 입력받아 해당 클래스명을 반환하는 메서드
	*/
	DbVO selectUri(String uri);
}
