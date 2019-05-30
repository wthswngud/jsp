<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>c:set - 로그인 후 테스트 할 것</h1>
	<!-- var : 속성명 -->
	<!-- value : 값 -->
	<!-- scope : page(default), request, session, application -->
	
	<c:set var="userId" value="${USER_INFO.alias}" scope="request"/>
	userId : ${userId}<br>
	requestScope.userId : ${requestScope.userId}<br><br>
	
	target 대상 속성, property : 대상 속성의 필드, value : 대입값<br>
<%-- 	<c:set target="${USER_INFO}" property="alias" value="bear"/> --%>
	USER_INFO.alias : ${USER_INFO.alias}<br>
	
	<h2>c:if *** c:if는 java의 if-else if -else 중에서 [if]에만 해당 (c:choose 태그가 일반적인 if문)</h2>
	
	<%-- if(test) --%>
	<c:if test="${USER_INFO.userId== 'brown'}">
		userId는 brown 입니다.
	</c:if>
	
	<c:if test="${USER_INFO.userId == 'sally'}">
		userId는 sally 입니다.
	</c:if>
	
	<h2>c:choose 자바의 if - else if - else</h2>
<%-- 	<c:choose > --%>
<%-- 		<c:if test = "${USER_INFO.userId == 'sally'}"> --%>
<!-- 			userId = sally입니다. -->
<%-- 		</c:if> --%>
<%-- 	</c:choose> --%>
	
	
	<h2>c:choose 자바의 if - else if - else</h2>
	<%
		request.setAttribute("code", "03");
	%>
	<c:choose>
		<!-- ==, eq -->
		<c:when test = "${code=='01'}">code is '01'</c:when>
		<c:when test = "${code=='02'}">code is '02'</c:when>
		<c:when test = "${code=='03'}">code is '03'</c:when>
		<c:otherwise>code is ${code}</c:otherwise>
	</c:choose>
	
	<h2>el 연산</h2>
	<%
		PageVO pageVO = new PageVO(1,10);
		request.setAttribute("pageVO", pageVO);
	%>
	page+2 : ${pageVO.page+2}
	
	
	<h2>c:forEach 일반 반복문</h2>
	<%-- for(int i=1; i<=10; i++ --%>
	<c:forEach begin="1" end="10" step="1" var="i">
		${i}<br>
	</c:forEach>
</body>
</html>