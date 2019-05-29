<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/jsp/requestDispatchProcess.jsp">
		<input type="text" name="userId" value = "sally"/>
		<input type="submit" value = "requestDispatch"/>
	</form>
</body>
</html>