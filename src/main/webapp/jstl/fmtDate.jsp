<%@page import="java.util.Date"%>
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
		width : 400px;
	}
</style>
</head>
<body>
<h2>formatDate</h2>
<c:set var="dt" value="<%=new Date()%>"/>
<div>
	dt : ${dt}<br>
	1.dt : <fmt:formatDate value="${dt}"/><br>
	2.dt : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd"/><br>
	3.dt : <fmt:formatDate value="${dt}" /><br>
	4.dt(FULL) : <fmt:formatDate value="${dt}" type="date" dateStyle="FULL"/><br>
	5.dt(MEDIUM) : <fmt:formatDate value="${dt}" dateStyle="MEDIUM"/><br>
	5.dt(SHORT) : <fmt:formatDate value="${dt}" dateStyle="SHORT"/><br>
	6.dt : <fmt:formatDate value="${dt}" type="both"/><br>
</div>

<h3>de(독일)</h3>
<div>
	<fmt:setLocale value="de_DE"/>
	dt : ${dt}<br>
	dt : <fmt:formatDate value="${dt}" pattern="yyyy-MM-dd" /><br>
</div>

<h2>parseDate(String->date / 2019.6.13->date)</h2>
<div>
	<fmt:setLocale value="ko"/>
	<c:set var="dtStr" value="2019.06.13"/>
	dtStr : ${dtStr}<br>
	dtStr(parseDate) : <fmt:parseDate value="${dtStr}"  pattern="yyyy.MM.dd"/><br>
</div>
</body>
</html>