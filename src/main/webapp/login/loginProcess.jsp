<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginProcess</title>
</head>
<body>
	loginProcess.jsp<br>
	<%--post 방식 한글 파라미터 --%>
	<%request.setCharacterEncoding("utf-8"); %><%--한글 형식을 깨지지 않게 변환작업 --%>
	
	<h2>request객체의 getParameter, getParameterValues</h2>
	request.getParameter("userId") : <%=request.getParameter("userId") %><br>
<%-- 	request.getParameterValues("userId") : <%String[] userIds = request.getParameterValues("userId"); --%>
<%-- 											for(String userId : userIds){%> --%>
<%-- 												<%=userId %><br> --%>
<%-- 											<%}%> --%>
	request.getParameter("userPW") : <%=request.getParameter("userPW") %>
	
	<h2>request객체의 getParameterMap</h2>
	<%Map<String, String[]> parameterMap = request.getParameterMap(); 
		//parameter : userId, password
		String[] userIdsFromMap = parameterMap.get("userId");
		for(String userId : userIdsFromMap){%>
			<%=userId %><br>
		<%}
		
		String[] password = parameterMap.get("userPW");
		
		for(String pass : password){%>
			<%=pass%><br>
		<%}%>
		<br>
	request.getParameterMap() : <%=request.getParameterMap() %><br>
	
	<h2>request객체의 getParameterNames()</h2>
	<% Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){%>
			parameterNames.nextElement() : <%=parameterNames.nextElement() %><br>
	<%}%>
</body>
</html>