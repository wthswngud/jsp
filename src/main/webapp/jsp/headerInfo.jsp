<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration<String> headers = request.getHeaderNames();
		
		while(headers.hasMoreElements()){
			String header = headers.nextElement();
			String headerValue = request.getHeader(header);
	%>
		
		header <%=header %> : <%=headerValue %><br>
	
	<%}%>
</body>
</html>