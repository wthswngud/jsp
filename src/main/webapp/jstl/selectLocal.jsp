<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$("#change").val("${id}");
		$("#change").change(function(){
// 			var id = $(this).val();
// 			$("#value").val(id);
			$("#frm").submit();
		})
	})
	
</script>
</head>
<body>

<h2>select Locale</h2>

<form id="frm" action="${pageContext.request.contextPath}/selectLocale" method="post">
	<select id="change" name="locale">
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${id=='ko'}"><option selected value="ko">한국어</option></c:when> --%>
<%-- 			<c:otherwise><option value="ko">한국어</option></c:otherwise> --%>
<%-- 		</c:choose> --%>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${id=='en'}"><option selected value="en">English</option></c:when> --%>
<%-- 			<c:otherwise><option value="en">English</option></c:otherwise> --%>
<%-- 		</c:choose> --%>
<%-- 		<c:choose> --%>
<%-- 			<c:when test="${id =='ja'}"><option selected value="ja">日本言</option></c:when> --%>
<%-- 			<c:otherwise><option value="ja">日本言</option></c:otherwise> --%>
<%-- 		</c:choose> --%>

<%-- 		<option <c:if test="${id == 'ko'}">selected</c:if> value="ko">한국어</option> --%>
<%-- 		<option <c:if test="${id == 'en'}">selected</c:if> value="en">English</option> --%>
<%-- 		<option <c:if test="${id == 'ja'}">selected</c:if> value="ja">日本言</option> --%>
		
		<option value="ko">한국어</option>
		<option value="en">English</option>
		<option value="ja">日本言</option>
	</select>
<!-- 	<input type="hidden" id="value" name="id"/> -->
</form>
<br>

<fmt:setLocale value="${id}"/>

<!-- 앞에는(패키지명).properties명 -->
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"></fmt:message><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/>
	</fmt:message>
</fmt:bundle>

</body>
</html>