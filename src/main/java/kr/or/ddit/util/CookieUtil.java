package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	public static String cookieString;		//분석할 쿠키 문자열
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	/**
	* Method : setCookieString
	* 작성자 : PC19
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다.
	*/
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString; 
	}

	/**
	* Method : getCookie
	* 작성자 : PC19
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다.
	*/
	public static String getCookie(String cookie) {
		String[] cookieArray = cookieString.split("; ");
		String cookieValue = "";
		// cookieName = cookieValue 형태로 되어있다.
		
		//cookieArray[0] = "userId = brown"
		//cookieArray[1] = "rememberme = true"
		//cookieArray[2] = "test = testValue"
		for(String str : cookieArray){
			logger.debug("str {}", str);
			
			//userid=brown
			//userId ==> "", "brown"
			if(str.startsWith(cookie)){
				String[] cookieStr = str.split("=");
				if(cookieStr[0].equals(cookie)){
					cookieValue = cookieStr[1];
				}
				break;
			}
		}
		
		return cookieValue;
	}
	
	
	/*
	public static String getCookie(String cookie) {
		//"userid=brown; rememberme=true; test=testValue"
		//cookie = "userId"
		
		String[] value1 = cookieString.split(" ");
		String result = null;
		boolean a = false;
		for(int i=0; i<value1.length; i++){
			a = value1[i].contains(cookie);
			logger.debug("문자열 : {}", a + " " + cookie);
			
			if(value1[i].contains(cookie)){
				
				int start = value1[i].indexOf("=");
				int end = value1[i].lastIndexOf(";");
				result = value1[i].substring(start+1, end);
			}
		}
		logger.debug("문자열 : {}", result);
		return result;
	}
	*/
}