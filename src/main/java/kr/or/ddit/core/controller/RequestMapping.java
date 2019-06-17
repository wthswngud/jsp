package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.service.DbServiceImpl;
import kr.or.ddit.service.IDbService;
import kr.or.ddit.uri.model.DbVO;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(RequestMapping.class);
	
	//	/main.do	 ->	MainController
	//	/userList.do -> UserListController
	
//	private static Map<String, String> requestMappingClass;
	private static Map<String, Controller> requestMapping;
	
	private static IDbService dbService = new DbServiceImpl();
	
	static{
		List<DbVO> urlClassMappingList = dbService.getUriClassMapping();
		
		requestMapping = new HashMap<String, Controller>();
		
		for(DbVO dbVo : urlClassMappingList){
			
			String classInfo = dbVo.getClassname();
			
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller) obj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		
//		requestMapping.put("/main.do", "kr.or.ddit.controller.MainController");
//		
//		requestMapping = new HashMap<String, Controller>();
//		
//		for(String key : requestMapping.keySet()){
//			
//			//classInfo = "kr.or.ddit.controller.MainController"
//			String classInfo = requestMapping.get(key);
		
//			try {
//				Class clazz = Class.forName(classInfo);
//				Object obj = clazz.newInstance();
//				requestMapping.put(key, (Controller)obj);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}
		
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
		
	}
	
	public static Controller getController(String uri) {
		logger.debug("get Controller : {}", uri);
		return requestMapping.get(uri);
	}
}
