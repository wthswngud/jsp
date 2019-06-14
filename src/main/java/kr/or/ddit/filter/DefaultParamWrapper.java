package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParamWrapper extends HttpServletRequestWrapper{
	private Map<String, String[]> paramMap;
	
	public DefaultParamWrapper(HttpServletRequest request) {
		super(request);
		paramMap = new HashMap<String, String[]>(request.getParameterMap());
	}

	@Override
	public String getParameter(String name) {
		String[] values = paramMap.get(name);
		return values == null ? null : values[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return paramMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(paramMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return paramMap.get("name");
	}
	
	public void setParameter(String name, String[] value){
		paramMap.put(name, value);
	}
}
