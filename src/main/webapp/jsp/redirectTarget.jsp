<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectTarget.jsp
	
	<%=
		System.out.println("userId parameter redirectTarget: " + request.getParameter("userId"))
	%>
</body>
</html>