<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a
			href="${pageContext.request.contextPath}/userList">사용자리스트</a></li>
		<li class="active"><a
			href="${pageContext.request.contextPath}/userPagingList?">사용자페이지리스트</a></li>
		<li class="active"><a
			href="${pageContext.request.contextPath}/userLprodList?">lprod 페이징 리스트</a></li>
	</ul>
</div>