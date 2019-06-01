<%@page import="kr.or.ddit.paging.model.PageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>사용자 상세조회</title>
<%@include file="/common/basicLib.jsp"%>
<script>
	$(document).ready(function(){
			var id = $("#labelId").text();
		$("#button").on("click", function(){
			$("#userId").val(id);
			
			$("#frm").submit();
		})
	})
</script>
</head>
<body>
	<!-- header -->
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- left -->
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자 상세 페이지</h2>
						

						<form id="frm" action="${pageContext.request.contextPath}/modify" class="form-horizontal" role="form">
							<input id="userId" name="userId" type="hidden"/>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">프로필 사진</label>
								<div class="col-sm-10">
									<img src="${pageContext.request.contextPath}/profile?userId=${userVO.userId}"/>
									<!--<input type="text" class="form-control" id="userId"> -->
									<!-- name="userId" placeholder="사용자 아이디"> -->
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자ID</label>
								<div class="col-sm-10">
									<label id="labelId" class="control-label">${userVO.userId}</label>
									<!--<input type="text" class="form-control" id="userId"> -->
									<!-- name="userId" placeholder="사용자 아이디"> -->
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자
									이름</label>
								<div class="col-sm-10">
									<label for="userId" class="control-label">${userVO.name}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<label class="control-label">${userVO.alias}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-10">
									<label class="control-label">${userVO.addr1}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<label class="control-label">${userVO.addr2}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<label class="control-label">${userVO.zipcd}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									<label class="control-label">
									<fmt:formatDate value="${userVO.birth}" pattern="yyyy-MM-dd" var="date"/>
									${date}</label>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="button" type="button" class="btn btn-default">사용자 수정</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>