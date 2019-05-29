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
				<div class="blog-header">
					<h1 class="blog-title">Main</h1>
					<p class="lead blog-description">Jsp / Spring.</p>
				</div>
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<h2 class="blog-post-title">JSP</h2>
							<p class="blog-post-meta">2017.10.30, room 201</p>
							
							<table class="table table-striped">
								<tr>
									<th>유저아이디</th>
									<th>유저 이름</th>
									<th>별명</th>
								</tr>
								<c:forEach items="${userList}" var="user">
									<tr>
										<td>${user.userId}</td>
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
									<%
									PageVO pageVo = (PageVO)request.getAttribute("pageVo");
									int paginationSize = (Integer)request.getAttribute("paginationSize");
									if(pageVo.getPage() == 1){%>
										<li class="disabled"><span>«</span></li>
									<%}else{%>
										<%int pn = pageVo.getPage()-1; %>
										<li><a href = "${pageContext.request.contextPath}/userPagingList?page=<%=pn%>&pageSize=<%=pageVo.getPageSize()%>"><span>«</span></a></li>
									<%} %>
									<%for(int i=1; i<= paginationSize; i++){%>
										<%if(pageVo.getPage() == i){%>
											<li class = active><span><%=i%></span></li>
										<%}
										if(pageVo.getPage() != i){%>
											<li><a href="${pageContext.request.contextPath}/userPagingList?page=<%=i%>&pageSize=<%=pageVo.getPageSize()%>"><%=i%></a></li>
										<%} %>
									<%}
									
									if(pageVo.getPage() == paginationSize){%>
										<li class = "disabled"><span>»</span></li>
									<%}else{%>
										<% int pn = pageVo.getPage()+1; %>
										<li><a href = "${pageContext.request.contextPath}/userPagingList?page=<%=pn%>&pageSize=<%=pageVo.getPageSize()%>"><span>»</span></li>
									<%} %>
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