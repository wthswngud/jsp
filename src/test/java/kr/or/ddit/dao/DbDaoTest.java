package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.dao.DbDaoImpl;
import kr.or.ddit.dao.IDbDao;
import kr.or.ddit.uri.model.DbVO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(DbDaoTest.class);
	private IDbDao dao = new DbDaoImpl();
	
	@Test
	public void selectAllListTest() {
		/***Given***/
		

		/***When***/
		List<DbVO> list = dao.getUriClassMapping();

		/***Then***/
		assertEquals(2, list.size());
	}
	
	@Test
	public void selectUriTest(){
		/***Given***/
		String uri = "/main.do";

		/***When***/
		DbVO vo = dao.selectUri(uri);

		/***Then***/
		logger.debug("vo : {}", vo);
	}
}
