<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자 리스트</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
</head>

<body>
	<!-- header -->
	<%@include file = "/common/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디(el)</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
								<%
// 									List<UserVO> userList = (List<UserVO>)request.getAttribute("userList");
								
// 									PagingList 20190519
									// ${userList}
									// List<UserVO> userList = (List<UserVO>)request.getAttribute("userList");
								%>	
								
								<!-- userList의 데이터를 한건 조회해서
									 pageContext.setAttribute("user", vo); -->
								<c:forEach items="${userList}" var="user">
									<tr>
										<td>${user.userId}</td>
										<td>${user.name}</td>
										<td>${user.alias}</td>
										<td></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						
						<a class="btn btn-default pull-right">사용자 등록</a>
						<!-- 사용자 수 : 105건
								 페이지네이션 : 11건 
							-->
							<div class="text-center">
							<ul class="pagination">
							
<!-- // 										// 내가 현재 몇번째 페이지에 있는가? -->
<!-- // 										PageVO pageVo = (PageVO)request.getAttribute("pageVo"); -->
<!-- // 										int paginationSize = (int)request.getAttribute("paginationSize"); -->
<%-- 										for(int i=1; i<= paginationSize; i++){%> --%>
<%-- 											<li><a href="${cp}
<%-- 										<%} --%>
<%-- 									%> --%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
