<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 국가명 -->
<h2>한국어(ko)</h2>
<fmt:setLocale value="ko"/>

<!-- 앞에는(패키지명).properties명 -->
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"></fmt:message><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<h2>영어(en)</h2>
<fmt:setLocale value="en"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"></fmt:message><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<h2>일본어(ja)</h2>
<fmt:setLocale value="ja"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"></fmt:message><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<h2>?</h2>
<fmt:setLocale value="msg"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"></fmt:message><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

<h2>setBundle</h2>
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="message"/>
<fmt:message key="GREETING" bundle="${message}"/><br>
<fmt:message key="VISITOR" bundle="${message}">
	<fmt:param value="brown"/>
</fmt:message>
</body>
</html>