<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div{
		border: 1px solid black;
		width : 300px;
	}
</style>
</head>
<body>
<%--
	pageContext.setAttribute("num", 1000000);
 --%>
<c:set value="1000000.55" var="num"/>
num : ${num} <br>

<fmt:setLocale value="ko_KR"/>
<br><br>
<h2>formatNumber(숫자를 포맷팅된 문자열로 바꾸는 것 == number->String / 1000000->1,000,000)</h2>
<div>
	기본 : <fmt:formatNumber value="${num}"/><br>
	ko(currency) : <fmt:formatNumber value="${num}" type="currency"/><br>
	ko(percentage) : <fmt:formatNumber value="${num}" type="percent"/><br>
</div>

<br><br>
<div>
	<fmt:setLocale value="de_DE"/>
	de : <fmt:formatNumber value="${num}"></fmt:formatNumber><br>
	de(currency) : <fmt:formatNumber value="${num}" type="currency"></fmt:formatNumber><br>
	de(percentage) : <fmt:formatNumber value="${num}" type="percent"></fmt:formatNumber><br>
</div>

<h2>parseNumber(String->number / 1,000,000->1000000)</h2>
<div>
	<fmt:setLocale value="ko"/>
	<c:set value="1,000,000" var="numStr"/>
	numStr : ${numStr}<br>
	parseNumber numStr : <fmt:parseNumber value="${numStr}" pattern="0,000"/>
	
</div>
</body>
</html>