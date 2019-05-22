<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		width: 300px;
	}
</style>
</head>
<body>
<!-- 어디로 요청을 보낼지? form태그 action속성
	 어떻게 보낼지 (http method) ?? form태그 속성 (get-default/ post)-->
<%-- /login/login.jsp -- loginProcess.jsp --%>
<form action = "<%=request.getContextPath()%>/login/loginProcess.jsp"
		method = "post">
	<fieldset>
	  	<legend>개인정보</legend>
		<!--name = ""을 작성 안하면 보내지지 않는다 -->
		user Id: <input type = "text" name="userId" value = "sally"><br>
		user Id: <input type = "text" name="userId" value = "샐리"><br>
		password: <input type = "password" name="userPW" value = "pass1234"><br>
		<input type = "submit" value="로그인"/>
	</fieldset>
</form>
</body>
</html>