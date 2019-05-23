<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/sumCalculation" method = "get">
		<input type="text" name="start" value = "1">
		<input type = "text" name = "end" value = 10>
		<button>submit</button>
	</form>
</body>
</html>