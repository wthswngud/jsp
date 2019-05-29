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
	<h2>jsp xcope 테스트</h2>
	
	<fieldset>
		<legend>scope 속성 테스트</legend>
		<form action="${pageContext.request.contextPath}/scope/scopeReceive.jsp" method = "post">
			page	<input type = "text" name = "pageParam" value = "pageValue"/><br>
			request <input type = "text" name = "requestParam" value = "requestValue"/><br>
			session <input type = "text" name = "sessionParam" value = "sessionValue"/><br>
			application <input type = "text" name = "applicationParam" value = "applicationValue"/><br>
			<button>전송하기</button>
		</form>
	</fieldset>
</body>
</html>