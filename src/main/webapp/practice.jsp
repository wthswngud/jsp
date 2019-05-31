<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin : 0px auto;
	}
	td{
		border : 1px solid black;
		padding : 10px;
	}
</style>
</head>
<body>
	<table>
		${param.dan}
		<c:choose>
			<c:when test="${param.dan==null}">
				<c:set var="param.dan" value="1"/>
			</c:when>
			<c:when test="${param.gob==null}">
				<c:set var="param.gob" value="9"/>
			</c:when>
		</c:choose>
		
		<c:forEach begin="1" end="${param.dan == null ? 9}" step="1" var="i">
			<tr>
				<c:forEach begin="2" end="${param.gob}" var="j" step="1">
					<td>${j}*${i} = ${j*i}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>