<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div{
		width : 350px;
		margin : 0px auto;
		border : 2px solid black;
		text-align: center;
	}
	span{
		font-size: 1.5em;
		font-weight: bold;
		
	}
</style>
</head>
<body>
	<div>
		session.getAttribute("mulResult") : <%= session.getAttribute("mulResult") %>
		<%--session.getAttribute("param2") : <%= session.getAttribute("mulResult") %> --%>
	</div>
</body>
</html>