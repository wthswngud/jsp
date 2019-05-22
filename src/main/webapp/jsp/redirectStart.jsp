<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 클라이언트 : 최초 요청을 보내는 페이지 -->
	<form action="<%=request.getContextPath()%>/jsp/redirectProcess.jsp">
		<input type="text" name="userId" value="sally"/>
		<input type = "submit" value = "redirect"/>
	</form>
</body>
</html>