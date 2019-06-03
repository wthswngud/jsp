package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtileTest {
	private static final Logger logger = LoggerFactory.getLogger(PartUtileTest.class);

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"Tulips.jpg\"";

		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);
		
		

		/***Then***/
		assertEquals("Tulips.jpg", fileName);

	}
	
	//uuid Test
	@Test
	public void uuidTest(){
		/***Given***/
		logger.debug("UUID.randomUUID().randomUUID().toString() : {}", UUID.randomUUID().toString());

		/***When***/

		/***Then***/

	}
	
	
	//확장자 명 반환하는지 테스트
	/**
	* Method : getExtTest
	* 작성자 : PC19
	* 변경이력 :
	* Method 설명 : 파일 확장자 확인 테스트
	*/
	@Test
	public void getExtTest(){
		/***Given***/
		String fileName = "sally.png";
		String fileName2 = "sally.picture.png";	//.을 두번 이상 붙일수 있다.
		String fileName3 = "sally";	// 확장자를 안적었을 경우

		/***When***/
		String ext = PartUtil.getExt(fileName);
		String ext2 = PartUtil.getExt(fileName2);
		String ext3 = PartUtil.getExt(fileName3);
		
		
		/***Then***/
		assertEquals(".png", ext);
		assertEquals(".png", ext2);
		assertEquals("", ext3);

	}
}
