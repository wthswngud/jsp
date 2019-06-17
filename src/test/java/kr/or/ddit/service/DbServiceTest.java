package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.uri.model.DbVO;

import org.junit.Test;

public class DbServiceTest {
	private IDbService service = new DbServiceImpl();

	@Test
	public void selectAllListTest() {
		/***Given***/
		

		/***When***/
		List<DbVO> list = service.getUriClassMapping();

		/***Then***/
		assertNotNull(list);
		assertEquals(2, list.size());
	}
}