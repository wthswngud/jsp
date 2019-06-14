<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table, tr, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<%-- application 속성 sessionMap 정보를 화면에 표현 --%>
	<h2>session</h2>
	<table>
			<tr>
				<th>session id</th>
				<th>USER_INFO.name</th>
			</tr>
		<c:forEach items="${sessionMap}" var="sess">
			<tr>
				<td>${sess.key}</td>
				<td>${sess.value.getAttribute("USER_INFO")}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>sessionUserMap</h2>
	<table>
		<tr>
			<th>사용자 아이디</th>
			<th>사용자 이름</th>
		</tr>
		<c:forEach items="${sessionUserMap}" var="map">
			<tr><td>${map.key}</td><td>${map.value}</td></tr>
		</c:forEach>
	</table>
</body>
</html>