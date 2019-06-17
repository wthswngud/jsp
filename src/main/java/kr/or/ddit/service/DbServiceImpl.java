package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.DbDaoImpl;
import kr.or.ddit.dao.IDbDao;
import kr.or.ddit.uri.model.DbVO;

public class DbServiceImpl implements IDbService{
	private IDbDao dao = new DbDaoImpl();

	/**
	* Method : selectUri
	* 작성자 : PC19
	* 변경이력 :
	* @return
	* Method 설명 : uri정보 전체 조회
	*/
	@Override
	public List<DbVO> getUriClassMapping() {
		return dao.getUriClassMapping();
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
		return dao.selectUri(uri);
	}
}
