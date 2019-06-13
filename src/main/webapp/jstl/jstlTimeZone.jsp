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
</head>
<body>
<h2>timeZone</h2>
<c:set value="<%=new Date()%>" var="dt"/>
dt : <fmt:formatDate value="${dt}" type="both"/>


<fmt:setTimeZone value="poland" var="pol"/><br>
dt : <fmt:formatDate value="${dt}" timeZone="${pol}" type="both"/><br>

<fmt:timeZone value="Poland">
	<fmt:formatDate value="${dt}" type="both"/><br>
</fmt:timeZone>
</body>
</html>