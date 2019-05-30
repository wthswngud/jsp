<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp" %>
</head>
<body>
		<!-- header -->
	<%@include file="/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<h2 class="blog-post-title">사용자 페이징 리스트</h2>
							
							<table class="table table-striped">
								<tr>
									<th>유저아이디</th>
									<th>유저 이름</th>
									<th>별명</th>
								</tr>
								<c:forEach items="${userList}" var="user" varStatus="status">
									<tr>
										<td>${status.index}/${status.count} / ${user.userId}</td>
										<td>${user.name}</td>
										<td>${user.alias}</td>
									</tr>
								</c:forEach>
							</table>
							
							<a class="btn btn-default pull-right">사용자 등록</a>
							
							<!-- 사용자 수 : 105건
								 페이지네이션 : 11건 
							-->
							<div class="text-center">
								<ul class="pagination">
								
									<c:set var="pageVo" value="${pageVo}" scope="request"/>
										
										
										
									<c:if test= "${pageVo.page==1}">
										<li class="disabled"><span>«</span></li>
									</c:if>
									<c:if test="${pageVo.page!=1 }">
										<li><a href = "${pageContext.request.contextPath}/userPagingList?page=${requestScope.pageVo.page-1}&pageSize=${requestScope.pageVo.pageSize}"><span>«</span></a></li>
									</c:if>



									<c:forEach begin="1" end="${paginationSize}" step="1" var="i" varStatus="String">
										<c:if test="${pageVo.page==i}">
											<li class = active><span>${i}</span></li>
										</c:if>
										<c:if test="${pageVo.page!=i}">
											<li><a href="${pageContext.request.contextPath}/userPagingList?page=${i}&pageSize=${pageVo.pageSize}">${i}</a></li>
										</c:if>
									</c:forEach>
									
									
									
									<c:choose>
										<c:when test="${pageVo.page == paginationSize}">
											<li class = "disabled"><span>»</span></li>
										</c:when>
										<c:otherwise>
											<li><a href = "${pageContext.request.contextPath}/userPagingList?page=${pageVo.page+1}&pageSize=${pageVo.pageSize}"><span>»</span></a></li>
										</c:otherwise>
									</c:choose>
								</ul>
							</div>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>