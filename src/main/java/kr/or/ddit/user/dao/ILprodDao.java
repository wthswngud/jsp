package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.LprodVO;

public interface ILprodDao {
	/**
	* Method : lprodAll
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 :lprod테이블의 데이터를 모두 갖고오는 메서드
	*/
	List<LprodVO> getLprod();
	
	
	/**
	* Method : getPageLprod
	* 작성자 : PC19
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :해당하는 페이지 리스트를 반환하는 메서드
	*/
	List<LprodVO> getPageLprod(PageVO pageVo);
	
	/**
	* Method : getLprodCnt
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 :lprod의 전체 수를 조회
	*/
	int getLprodCnt();
}
