package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.LprodVO;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;

public class LprodDaoImpl implements ILprodDao{
	/**
	* Method : lprodAll
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 :lprod테이블의 데이터를 모두 갖고오는 메서드
	*/
	@Override
	public List<LprodVO> getLprod() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO>list = sqlSession.selectList("user.getLprod");
		sqlSession.close();
		return list;
	}
	
	/**
	* Method : getPageLprod
	* 작성자 : PC19
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 :해당하는 페이지 리스트를 반환하는 메서드
	*/
	public List<LprodVO> getPageLprod(PageVO pageVo){
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> list = sqlSession.selectList("user.getPageLprod", pageVo);
		sqlSession.close();
		return list;
	}


	/**
	* Method : getLprodCnt
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 :lprod의 전체 수를 조회
	*/
	@Override
	public int getLprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int result = sqlSession.selectOne("user.getLprodCnt");
		return result;
	}
}
