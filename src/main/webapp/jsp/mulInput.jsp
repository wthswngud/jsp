<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		width : 300px;
		margin : 0px auto;
	}
</style>
</head>
<body>

	<fieldset>
		<legend>입력</legend>
		<form action="<%=request.getContextPath()%>/mulCalculation" method = "post">
			param1 : <input type="text" name = "param1" value = "2">
			param2 : <input type="text" name = "param2" value = "10">
			<button>계산</button>
		</form>
	</fieldset>
</body>
</html>