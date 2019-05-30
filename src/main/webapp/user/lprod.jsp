<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="kr.or.ddit.user.model.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
						<h2 class="sub-header">Lprod</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>Lprod_ID</th>
									<th>Lprod_NM</th>
									<th>Lprod_gu</th>
								</tr>
								
<%-- 								<c:forEach begin="1" end="${pageList.size()}" step="1" var="i"> --%>
<%-- 									<c:set var="pageVO" value="${pageList.get(i)}"/> --%>
<!-- 									<tr> -->
<%-- 										<td>${pageVO.lprod_id}</td> --%>
<%-- 										<td>${pageVO.lprod_nm}</td> --%>
<%-- 										<td>${pageVO.lprod_gu}</td> --%>
<!-- 									</tr> -->
<%-- 								</c:forEach> --%>
								
								<%List<LprodVO> list = (List<LprodVO>)request.getAttribute("pageList");
								PageVO pageVO = (PageVO)request.getAttribute("pageVO");
								int pagenation = (Integer)request.getAttribute("pagenation");
								for(int i=0; i<list.size(); i++){%>
									<tr>
										<td><%=list.get(i).getLprod_id()%></td>
										<td><%=list.get(i).getLprod_nm() %></td>
										<td><%=list.get(i).getLprod_gu() %></td>
									</tr>
								<%}%>
							</table>
							
							<c:set var="pageVo" value="pageVo"/>
							
							<div class = "text-center">
								<ul class = "pagination">
									<c:if test="${pageVO.getPage()==1}">
										<li class=disabled><span>«</span></li>
									</c:if>
									<c:if test="${pageVO.getPage()!=1}">
										<li><a href = "${pageContext.request.contextPath}/userLprodList?page=<%=pageVO.getPage()-1%>&pageSize=<%=pageVO.getPageSize()%>"><span>«</span></a></li>
									</c:if>
									<%for(int i=1; i<=pagenation; i++){ 
										if(pageVO.getPage()==i){%>
										<li class = active><span><%=i%></span></li>
									<%	}else{%>
										<li><a href = "${pageContext.request.contextPath}/userLprodList?page=<%=i%>&pageSize=<%=pageVO.getPageSize()%>"><%=i%></a></li>
										<%}
									}%>
									<c:if test="${pageVO.page==pagenation}">
										<li class=disabled><span>»</span></li>
									</c:if>
									<c:if test="${pageVO.page!=pagenation}">
										<li><a href = "${pageContext.request.contextPath}/userLprodList?page=${pageVO.page+1}&pageSize=${pageVO.pageSize}"><span>»</span></a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>