package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.uri.model.DbVO;

public class DbDaoImpl implements IDbDao{
	/**
	* Method : selectUri
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : uri정보 전체 조회
	*/
	@Override
	public List<DbVO> getUriClassMapping() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVO> list = sqlSession.selectList("uri.selectAllList");
		sqlSession.close();
		return list;
	}

	/**
	* Method : selectUri
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : uri를 입력받아 해당 클래스명을 반환하는 메서드
	*/
	@Override
	public DbVO selectUri(String uri) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		DbVO vo = sqlSession.selectOne("uri.selectUri", uri);
		sqlSession.close();
		return vo;
	}
}
