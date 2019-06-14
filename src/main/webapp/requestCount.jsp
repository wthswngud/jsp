<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<%--application(getServletContext) : requestMap --%>
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
		</tr>
		<c:forEach items="${requestMap}" var="map">
			<tr>
				<td>${map.key}</td>
				<td>${map.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>