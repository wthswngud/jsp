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
		<c:choose>
			<c:when test="${param.dan==null}">
				<c:set var="dan" value="9"/>
			</c:when>
			<c:otherwise>
				<c:set var="dan" value="${param.dan}"/>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.gob==null}">
				<c:set var="gob" value="9"/>
			</c:when>
			<c:otherwise>
				<c:set var="gob" value="${param.gob}"/>
			</c:otherwise>
		</c:choose>
		
		<c:forEach begin="1" end="${gob}" step="1" var="i">
			<tr>
				<c:forEach begin="2" end="${dan}" var="j" step="1">
					<td>${j}*${i} = ${j*i}</td>
				</c:forEach>
			</tr>
		</c:forEach>
		
<%-- 		<c:forEach begin="1" end="${param.gob == null ? 9 : param.gob}" step="1" var="i"> --%>
<!-- 			<tr> -->
<%-- 				<c:forEach begin="2" end="${empty param.dan ? 9 : param.dan}" var="j" step="1"> --%>
<%-- 					<td>${j}*${i} = ${j*i}</td> --%>
<%-- 				</c:forEach> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
	</table>
</body>
</html>